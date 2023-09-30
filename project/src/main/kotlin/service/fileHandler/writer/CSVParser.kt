import utils.Helpers
import utils.Constants
import kotlin.reflect.full.declaredMemberProperties

object CSVParser {
    fun <T : Any> parseLine(objectT: T, isHeader: Boolean): String {
        val objectMembers = discoverAttributesAndValues(objectT)

        val line: String = if(isHeader){
            Helpers.listToStringWithSeparator(objectMembers.map { it.key }, Constants.CSV_SEPARATOR)
        } else {
            Helpers.listToStringWithSeparator(objectMembers.map { it.value }, Constants.CSV_SEPARATOR)
        }

        return line
    }

    private fun <T : Any> discoverAttributesAndValues(objectT: T): Map<String, String> {
        val attributeAndValues = mutableMapOf<String, String>()
        if (objectT::class.isData) {
            objectT::class.declaredMemberProperties.forEach { property ->
                attributeAndValues[property.name] = property.getter.call(objectT).toString()
            }
        } else {
            throw IllegalArgumentException("The object is not a data class")
        }
        return attributeAndValues
    }
}

package service.converter

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.csv.CsvSchema
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import utils.Constants
import utils.EnvVars
import utils.Helpers
import java.io.File


object CsvToXml : Convertible {
    override fun convert(filePath: String) {
//        val input = File(EnvVars.BASE_PATH + "/" + filePath + Constants.CSV_EXTENSION)
//        val output = File(EnvVars.BASE_PATH + "/" + filePath + Constants.XML_EXTENSION)
        val input = File(filePath)
        val output = File(Helpers.removeFileExtension(filePath) + Constants.XML_EXTENSION)

        try {
            val csv = CsvSchema.emptySchema().withHeader()
            val csvMapper = CsvMapper()
            val xmlMapper = XmlMapper()

            val mappingIterator = csvMapper.reader().forType(
                MutableMap::class.java
            ).with(csv).readValues<Map<*, *>>(input)
            val list = mappingIterator.readAll()

            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT)
            val xml = xmlMapper.writeValueAsString(list)

            output.writeText(xml)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
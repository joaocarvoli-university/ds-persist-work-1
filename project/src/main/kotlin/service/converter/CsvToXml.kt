package service.converter

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.csv.CsvSchema
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import utils.Constants
import utils.EnvVars
import java.io.File
import java.io.IOException


object CsvToXml : Convertible {
    override fun convert(fileName: String) {
        val input = File(EnvVars.BASE_PATH + "/" + fileName + Constants.CSV_EXTENSION)
        val output = File(EnvVars.BASE_PATH + "/" + fileName + Constants.XML_EXTENSION)

        try {
            val csv = CsvSchema.emptySchema().withHeader()
            val csvMapper = CsvMapper()
            val xmlMapperectMapper = XmlMapper()

            val mappingIterator = csvMapper.reader().forType(
                MutableMap::class.java
            ).with(csv).readValues<Map<*, *>>(input)
            val list = mappingIterator.readAll()

            xmlMapperectMapper.enable(SerializationFeature.INDENT_OUTPUT)
            val xml = xmlMapperectMapper.writeValueAsString(list)

            output.writeText(xml)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
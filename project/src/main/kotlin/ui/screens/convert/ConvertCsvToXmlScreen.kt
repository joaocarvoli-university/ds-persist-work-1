package ui.screens.convert

import service.converter.CsvToJson
import service.converter.CsvToXml
import java.lang.Exception

object ConvertCsvToXmlScreen {
    fun showOptions() {
        println("\n-----> CSV TO XML MENU <-----")
        print("Insert the path of the CSV file that you wants to convert: ")
        val csvFilePath = readln()

        if(convertCsvToXml(csvFilePath)) println("File converted successfully")
        else println("A problem occurred during file conversion")

    }

    private fun convertCsvToXml(fileName: String): Boolean {
        val csvConverterToXml = CsvToXml

        return try {
            csvConverterToXml.convert(fileName)
            true
        } catch (ex: Exception){
            false
        }
    }
}
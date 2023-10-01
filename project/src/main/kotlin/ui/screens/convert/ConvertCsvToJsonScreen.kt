package ui.screens.convert

import service.converter.CsvToJson
import java.lang.Exception

object ConvertCsvToJsonScreen {
    fun showOptions() {
        println("\n-----> CSV TO JSON MENU <-----")
        print("Insert the path of the CSV file that you wants to convert: ")
        val csvFilePath = readln()

        if(convertCsvToJson(csvFilePath)) println("File converted successfully")
        else println("A problem occurred during file conversion")
    }

    private fun convertCsvToJson(fileName: String): Boolean {
        val csvConverterToJson = CsvToJson

        return try {
            csvConverterToJson.convert(fileName)
            true
        } catch (ex: Exception){
            false
        }
    }
}
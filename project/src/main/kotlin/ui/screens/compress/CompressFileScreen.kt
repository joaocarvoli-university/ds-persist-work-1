package ui.screens.compress

import service.compressor.ZIPCompression
import ui.screens.convert.ConvertCsvToJsonScreen

object CompressFileScreen {
    fun showOptions() {
        println("\n-----> ZIP COMPRESSOR MENU <-----")
        print("Insert the path of the file that you wants to compress: ")
        val filePath = readln()

        if(compressFileIntoZip(filePath)) println("File compressed successfully")
        else println("A problem occurred during file compression")
    }

    private fun compressFileIntoZip(filePath: String): Boolean {
        val zipCompression = ZIPCompression

        return try {
            zipCompression.compress(filePath)
            true
        } catch (ex: Exception){
            false
        }
    }
}
package ui.screens.dataProfiling

import service.dataProfiling.CSVSummary
import java.lang.Exception

object CsvDataProfilingScreen {
    fun showOptions() {
        println("\n-----> CSV Data Profiling <-----")
        print("Insert the path of the CSV file that you wants to get statistics: ")
        val csvFilePath = readln()

        val entitiesAmount = csvDataProfilingEntities(csvFilePath)
        if (entitiesAmount != -1) println("The amount of entities is: $entitiesAmount")
        else println("An error occurred during data profiling task")

        println()
    }

    private fun csvDataProfilingEntities(fileName: String): Int {
        val csvSummary = CSVSummary

        return try {
            csvSummary.getEntitiesAmount(fileName)
        } catch (ex: Exception){
            -1
        }
    }
}
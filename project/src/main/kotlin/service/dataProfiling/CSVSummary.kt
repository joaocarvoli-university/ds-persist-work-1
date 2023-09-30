package service.dataProfiling

import utils.Helpers
import utils.Constants

object CSVSummary {
    fun getEntitiesAmount(fileName: String): Int {
        val headerLine: String = Helpers.convertFileToString(fileName, 0, Constants.CSV_EXTENSION)
        val header = headerLine.split(Constants.CSV_SEPARATOR).size
        return header - 1
    }
}
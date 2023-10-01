package service.dataProfiling

import utils.Helpers
import utils.Constants

object CSVSummary {
    fun getEntitiesAmount(filePath: String): Int {
        val headerLine: String = Helpers.convertFileToString(filePath, 0)
        val header = headerLine.split(Constants.CSV_SEPARATOR).size
        return header - 1
    }
}
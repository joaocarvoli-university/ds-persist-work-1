package ui.screens.validation

import com.ctc.wstx.shaded.msv_core.verifier.jarv.Const
import service.dataProfiling.CSVSummary
import utils.Constants
import utils.Helpers
import java.lang.Exception

object SHA256GeneratorScreen {
    fun showOptions() {
        println("\n-----> SHA-256 Generator <-----")
        print("Insert the path of the file that you wants to see the SHA-256: ")
        val filePath = readln()

        val sha256Key = sha256(filePath)
        if (sha256Key != null) println("The key is: $sha256Key")
        else println("An error occurred during SHA-256 generator")

        println()
    }

    private fun sha256(fileName: String): String? {
        return try {
            Helpers.calculateHash(fileName, Constants.SHA_256)
        } catch (ex: Exception){
            null
        }
    }
}
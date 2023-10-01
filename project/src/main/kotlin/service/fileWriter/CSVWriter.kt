package service.fileWriter

import service.fileHandler.fileWriter.Writeable
import utils.Helpers
import utils.Constants
import utils.EnvVars
import java.io.File
import java.lang.NullPointerException

class CSVWriter<T> : Writeable<T> {
    private var objectT : T? = null

    override fun writes(fileName: String) {
        if(objectT != null){
            val fileExists = File(EnvVars.BASE_PATH + "/" + fileName + Constants.CSV_EXTENSION).exists()

            if(fileExists){
                Helpers.appendLineToFile(fileName, CSVParser.parseLine(objectT!!, false), Constants.CSV_EXTENSION)
            } else {
                Helpers.appendLineToFile(fileName, CSVParser.parseLine(objectT!!, true), Constants.CSV_EXTENSION)
                Helpers.appendLineToFile(fileName, CSVParser.parseLine(objectT!!, false), Constants.CSV_EXTENSION)
            }
        } else {
            throw NullPointerException("You must to load the object before call this method")
        }
    }

    override fun loadObject(objectT: T) {
        this.objectT = objectT
    }
}
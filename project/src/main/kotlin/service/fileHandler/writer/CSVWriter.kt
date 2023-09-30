package service.fileHandler.writer

import common.Helpers
import utils.Constants
import java.lang.NullPointerException

class CSVWriter<T> : Writeable<T> {
    private var objectT : T? = null
    private var fileExists = false

    override fun writes(fileName: String) {
        if(objectT != null){
            if(fileExists){
                Helpers.appendLineToFile(fileName, CSVParser.parseLine(objectT!!, false), Constants.CSV_EXTENSION)
            } else {
                Helpers.appendLineToFile(fileName, CSVParser.parseLine(objectT!!, true), Constants.CSV_EXTENSION)
                Helpers.appendLineToFile(fileName, CSVParser.parseLine(objectT!!, false), Constants.CSV_EXTENSION)
                fileExists = true
            }
        } else {
            throw NullPointerException("You must to load the object before call this method")
        }
    }

    override fun loadObject(objectT: T) {
        this.objectT = objectT
    }
}
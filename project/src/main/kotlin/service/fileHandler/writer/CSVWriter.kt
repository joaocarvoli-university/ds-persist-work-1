package service.fileHandler.writer

import common.Helpers
import java.lang.NullPointerException

class CSVWriter<T> : Writeable<T> {
    private var objectT : T? = null
    private var fileExtension = "csv"
    private var fileExists = false

    override fun writes(fileName: String) {
        if(objectT != null){
            if(fileExists){
                Helpers.appendLineToFile(fileName, CSVParser.parseLine(objectT!!, false), fileExtension)
            } else {
                Helpers.appendLineToFile(fileName, CSVParser.parseLine(objectT!!, true), fileExtension)
                Helpers.appendLineToFile(fileName, CSVParser.parseLine(objectT!!, false), fileExtension)
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
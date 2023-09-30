package service.fileHandler.fileWriter

interface Writeable<T> {
    fun writes(fileName: String)
    fun loadObject(objectT: T)
}
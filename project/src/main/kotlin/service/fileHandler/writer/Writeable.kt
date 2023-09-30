package service.fileHandler.writer

interface Writeable<T> {
    fun writes(fileName: String)
    fun loadObject(objectT: T)
}
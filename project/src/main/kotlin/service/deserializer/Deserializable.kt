package service.deserializer

interface Deserializable<T> {
    fun addObject(objectT: T)
    fun deserialize(fileName: String): T
    fun readsObject()
}
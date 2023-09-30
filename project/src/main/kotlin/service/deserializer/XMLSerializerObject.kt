package service.deserializer

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import utils.EnvVars
import java.io.File

class XMLDeserializerObject<T: Any>(private val clazz: Class<T>): Deserializable<T> {
    private lateinit var objectT: T
    private lateinit var fileName: String


    override fun addObject(objectT: T){
        this.objectT = objectT
    }

    override fun deserialize(fileName: String): T {
        this.fileName = fileName
        readsObject()
        return objectT
    }

    override fun readsObject() {
        try {
            val file = File(EnvVars.BASE_PATH + fileName)
            val xmlMapper = XmlMapper()
            this.objectT = xmlMapper.readValue(file, clazz) as T
        } catch (e: Exception){
            throw e
        }
    }
}
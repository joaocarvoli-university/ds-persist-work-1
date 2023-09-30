package service.deserializer

import utils.EnvVars
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File

class JSONDeserializerObject<T: Any>(private val clazz: Class<T>): Deserializable<T> {
    private lateinit var objectT: T
    private lateinit var fileName: String

    override fun addObject(objectT: T) {
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
            val jsonMapper = ObjectMapper()
            this.objectT = jsonMapper.readValue(file, clazz) as T
        } catch (e: Exception){
            throw e
        }
    }
}
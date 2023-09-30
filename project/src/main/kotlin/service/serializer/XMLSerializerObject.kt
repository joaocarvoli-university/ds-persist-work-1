package service.serializer

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import utils.EnvVars
import java.io.File

class XMLSerializerObject<T: Any>: Serializable<T> {
    private lateinit var objectT: T
    private lateinit var fileName: String

    override fun addObject(objectT: T){
        this.objectT = objectT
    }

    override fun serialize(fileName: String){
        this.fileName = fileName
        writesObject()
    }

    override fun writesObject(){
        val file = File(EnvVars.BASE_PATH + fileName)
        val xmlMapper = XmlMapper()
        try {
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT)
            xmlMapper.writeValue(file, objectT)
        } catch (e: Exception){
            println(e.message)
        }
    }
}
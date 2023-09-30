package common

import utils.EnvVars
import java.io.File
import java.io.FileOutputStream

object Helpers {
    fun <T> listToStringWithSeparator(list: List<T>, separator: String): String {
        val stringBuilder = StringBuilder()
        list.forEach {
            stringBuilder.append(it).append(separator)
        }
        return stringBuilder.toString()
    }

    fun appendLineToFile(fileName: String, content: String, extension: String = ""){
        try {
            if(!File(EnvVars.BASE_PATH).exists()){
                File(EnvVars.BASE_PATH).mkdir()
            }
            val file = File(EnvVars.BASE_PATH + "/" + fileName + "." + extension)

            FileOutputStream(file, true).use { fileOutputStream ->
                fileOutputStream.write("$content\n".toByteArray())
            }
        } catch (exception: Exception){
            println(exception)
        }
    }
}
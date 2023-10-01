package utils

import java.io.*
import java.security.MessageDigest

object Helpers {
    fun calculateHash(filePath: String, algorithm: String): String {
//        val file = File(EnvVars.BASE_PATH + "/" + fileName)
        val file = File(filePath)
        val messageDigest = MessageDigest.getInstance(algorithm)
        val inputStream = file.inputStream()
        val buffer = ByteArray(4096)
        var bytesRead: Int

        while (inputStream.read(buffer).also { bytesRead = it } != -1) {
            messageDigest.update(buffer, 0, bytesRead)
        }

        val bytes = messageDigest.digest()
        return bytes.joinToString("") { "%02x".format(it) }
    }

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
            val file = File(EnvVars.BASE_PATH + "/" + fileName + extension)

            FileOutputStream(file, true).use { fileOutputStream ->
                fileOutputStream.write("$content\n".toByteArray())
            }
        } catch (exception: Exception){
            println(exception)
        }
    }

    fun convertFileToString(filePath: String, linesLimit: Int? = null, extension: String = ""): String{
//        val inputStream: InputStream = FileInputStream(EnvVars.BASE_PATH  + "/" + filePath + extension)
        val inputStream: InputStream = FileInputStream(filePath)
        val inputStreamReader = InputStreamReader(inputStream)
        val bufferedReader = BufferedReader(inputStreamReader)
        val fileContent = bufferedReader.readLine()
        var counter = linesLimit
        val stringBuilder = StringBuilder()

        while(fileContent != null){
            if(counter == -1) break
            stringBuilder.append(fileContent)
            if (counter != null) {
                counter -= 1
            }
        }

        bufferedReader.close()

        return stringBuilder.toString()
    }

    private fun removeCharFromString(input: String, char: Char): String {
        return input.filter { it != char}
    }

    fun removeFileExtension(fileName: String): String{
        var zipName = fileName.split(".").dropLast(1).toString()
        zipName = removeCharFromString(zipName, '[')
        zipName = removeCharFromString(zipName, ']')
        return zipName
    }
}
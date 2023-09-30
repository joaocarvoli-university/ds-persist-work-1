package service.compressor

import utils.Helpers
import utils.Constants
import utils.EnvVars
import java.io.*
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

object ZIPCompression : Compressible {
    override fun compress(fileName: String) {
        val file = File(EnvVars.BASE_PATH + "/" + fileName)
        val zipFile = File(EnvVars.BASE_PATH + "/" + Helpers.removeFileExtension(fileName) + Constants.ZIP_EXTENSION)

        try {
            FileOutputStream(zipFile).use { fos ->
                ZipOutputStream(BufferedOutputStream(fos)).use { out ->
                    FileInputStream(file).use { fis ->
                        BufferedInputStream(fis).use { origin ->
                            val entry = ZipEntry(file.name)
                            out.putNextEntry(entry)
                            origin.copyTo(out, 1024)
                        }
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            println("Error: Failed to compress $fileName")
        }
    }
}
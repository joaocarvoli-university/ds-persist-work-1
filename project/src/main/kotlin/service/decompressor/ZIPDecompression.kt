package service.decompressor

import utils.Constants
import utils.Helpers
import utils.EnvVars
import java.io.*
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

object ZIPDecompression : Decompressible {
    override fun decompress(fileName: String) {
        val zipFile = File(EnvVars.BASE_PATH + "/" + fileName)
        val targetDir = File(EnvVars.BASE_PATH + "/" + Constants.DECOMPRESSED + Helpers.removeFileExtension(fileName))

        try {
            ZipInputStream(FileInputStream(zipFile)).use { zipStream ->
                var entry: ZipEntry? = zipStream.nextEntry

                while (entry != null) {
                    val entryFile = File(targetDir, entry.name)
                    if (entry.isDirectory) {
                        entryFile.mkdirs()
                    } else {
                        entryFile.parentFile?.mkdirs()
                        FileOutputStream(entryFile).use { fileOutput ->
                            zipStream.copyTo(fileOutput)
                        }
                    }
                    entry = zipStream.nextEntry
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
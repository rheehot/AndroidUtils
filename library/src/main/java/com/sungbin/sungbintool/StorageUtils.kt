package com.sungbin.sungbintool

import android.annotation.SuppressLint
import android.os.Environment
import java.io.*
import java.text.DecimalFormat
import kotlin.math.log10
import kotlin.math.pow


@Suppress("DEPRECATION")
@SuppressLint("MissingPermission", "HardwareIds")
object StorageUtils {
    val sdcard = Environment.getExternalStorageDirectory().absolutePath

    private fun String.parsePath() = if (this.contains(sdcard)) this else "$sdcard/$this"

    fun createFolder(path: String, autoInputSdcard: Boolean = false) =
        File(if (autoInputSdcard) path.parsePath() else path).mkdirs()

    fun createFile(path: String, autoInputSdcard: Boolean = false) =
        File(if (autoInputSdcard) path.parsePath() else path).createNewFile()

    fun getSize(size: Long): String {
        if (size <= 0) return "0"
        val units = arrayOf("B", "KB", "MB", "GB", "TB")
        val digitGroups = (log10(size.toDouble()) / log10(1000.0)).toInt()
        return DecimalFormat("#,##0.#").format(
            size / 1000.0.pow(digitGroups.toDouble())
        ).toString() + " " + units[digitGroups]
    }

    fun getFileSize(file: File) = getSize(file.length())

    fun read(path: String, _null: String?, autoInputSdcard: Boolean = false): String? {
        return try {
            val file = File(if (autoInputSdcard) path.parsePath() else path)
            if (!file.exists()) return _null
            val fis = FileInputStream(file)
            val isr = InputStreamReader(fis)
            val br = BufferedReader(isr)
            var str = br.readLine()

            while (true) {
                val inputLine = br.readLine() ?: break
                str += "\n" + inputLine
            }

            fis.close()
            isr.close()
            br.close()
            if (str == null) {
                _null
            } else {
                str + ""
            }
        } catch (ignored: Exception) {
            _null
        }
    }

    fun save(path: String, content: String, autoInputSdcard: Boolean = false): Boolean {
        return try {
            val file = File(if (autoInputSdcard) path.parsePath() else path)
            val fos = FileOutputStream(file)
            fos.write(content.toByteArray())
            fos.close()
            true
        } catch (ignored: Exception) {
            false
        }
    }

    fun delete(path: String, autoInputSdcard: Boolean = false) =
        File(if (autoInputSdcard) path.parsePath() else path).delete()

    fun deleteAll(path: String, autoInputSdcard: Boolean = false): Boolean {
        return try {
            val dir = File(if (autoInputSdcard) path.parsePath() else path)
            if (dir.exists() && dir.listFiles() != null) {
                for (childFile in dir.listFiles()!!) {
                    if (childFile.isDirectory) {
                        deleteAll(childFile.absolutePath)
                    } else {
                        childFile.delete()
                    }
                }
                dir.delete()
            }
            true
        } catch (ignored: Exception) {
            false
        }
    }
}
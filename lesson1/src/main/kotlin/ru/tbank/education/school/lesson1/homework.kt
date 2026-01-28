package ru.tbank.education.school.lesson1

import java.io.*
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.zip.*



fun archiver(path_to_dir: String, path_to_archive: String){
    val filename = "notes.txt"
    try {
        ZipOutputStream(FileOutputStream(path_to_archive).use { zout ->
            FileInputStream(filename).use { fis ->
                val entry1 = ZipEntry("notes.txt")
                zout.write(entry1)
                // считываем содержимое файла в массив byte
                val buffer = ByteArray(fis.available())
                fis.read(buffer)
                // добавляем содержимое к архиву
                zout.write(buffer)
                // закрываем текущую запись для новой записи
                zout.closeEntry()
            }
        }
    } catch (ex: Exception) {
        println(ex.message)
    }


}

package com.example.mysavefileapplication

import android.content.Context
import java.io.*

class MyFileSaver(private val context: Context) {
    private val fileName: String = "my_file"
    var fileContent: String = ""

    fun writeToFile(content: String) {
        fileContent = content
        context.openFileOutput(fileName, Context.MODE_PRIVATE).use {
            it.write(fileContent.toByteArray())
        }

    }

    fun readFromFile(): String {

        if(fileName !=null && fileName.trim()!=""){
            var fileInputStream: FileInputStream? = context.openFileInput(fileName)
            var inputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder: StringBuilder = StringBuilder()
            var content: String?
            while (run {
                    content = bufferedReader.readLine()
                    content
                } != null) {
                stringBuilder.append(content)
            }
            return stringBuilder.toString()
        }else{
            return "Nothing to show"
        }
    }
}
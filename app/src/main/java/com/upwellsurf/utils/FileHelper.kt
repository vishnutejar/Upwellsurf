package com.upwellsurf.utils

import android.content.Context
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class FileHelper {
    val FILENAME = "listinfo.dat"
    fun writeData(context: Context, item: ArrayList<String> ){
        val fos: FileOutputStream = context.openFileOutput(FILENAME, Context.MODE_PRIVATE)
        val oas = ObjectOutputStream(fos)
        oas.writeObject(item)
        oas.close()
    }

    fun readData(context: Context): ArrayList<String>{
        var itemList:ArrayList<String>

        try{
            val fis: FileInputStream = context.openFileInput(FILENAME)
            val ois = ObjectInputStream(fis)
            itemList = ois.readObject() as ArrayList<String>
        }
        catch (e: FileNotFoundException){
            itemList = ArrayList<String>()
        }
        return itemList
    }
}
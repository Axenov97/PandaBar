package com.bignerdanch.pandabar.Model

import android.content.ContentValues
import android.content.Context
import com.bignerdanch.pandabar.Contract.Contract
import com.bignerdanch.pandabar.database.DBHelper
import com.bignerdanch.pandabar.database.PandaDbSchema.PandaTable.Cols.*
import com.bignerdanch.pandabar.database.PandaDbSchema.PandaTable.NAME

class TableModel: Contract.Model {

    private lateinit var cursorCount:String
    private lateinit var cursorTea:String
    private lateinit var cursorCake:String

    private lateinit var dbHelper: DBHelper

    override fun addCount(context: Context, count: String, tea:String, cake:String, id: String) {
        dbHelper = DBHelper(context)
        val database = dbHelper.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(ID, id)
        contentValues.put(COUNT, count)
        contentValues.put(TEA, tea)
        contentValues.put(CAKE, cake)
        database.insert(NAME, null, contentValues)
        dbHelper.close()
    }

    override fun calcCost(context: Context, count: String, tea: String, cake: String, id: String):Int {
        val selection = "id = ?"
        val selectionArgs = arrayOf(id)
        dbHelper = DBHelper(context)
        val database = dbHelper.readableDatabase
        val cursor =
            database.query(NAME, null, selection, selectionArgs, null, null, null)
        if (cursor.moveToFirst()) {
            val countIndex = cursor.getColumnIndex(COUNT)
            val teaIndex = cursor.getColumnIndex(TEA)
            val cakeIndex = cursor.getColumnIndex(CAKE)
            do {
                cursorCount = cursor.getString(countIndex)
                cursorTea = cursor.getString(teaIndex)
                cursorCake = cursor.getString(cakeIndex)
            } while (cursor.moveToNext())
        } else {
            cursorCount = "0"
            cursorTea= "0"
            cursorCake = "0"
        }

        val count:Int = cursorCount.toInt()
        val priceAll =cursorTea.toInt()*400 + cursorCake.toInt()*300
        cursor.close()
        dbHelper.close()
        return priceAll
    }

    //почему-то не работает через гетдатабэйс, Count пока напрямую вызываю
    override fun returnCount(context: Context, id: String): String {
        val selection = "id = ?"
        val selectionArgs = arrayOf(id)
        dbHelper = DBHelper(context)
        val database = dbHelper.readableDatabase
        val cursor =
            database.query(NAME, null, selection, selectionArgs, null, null, null)
        if (cursor.moveToFirst()) {
            val countIndex = cursor.getColumnIndex(COUNT)
            val teaIndex = cursor.getColumnIndex(TEA)
            val cakeIndex = cursor.getColumnIndex(CAKE)
            do {
                cursorCount = cursor.getString(countIndex)
                cursorTea = cursor.getString(teaIndex)
                cursorCake = cursor.getString(cakeIndex)
            } while (cursor.moveToNext())
        } else {
            cursorCount = "0"
            cursorTea= "0"
            cursorCake = "0"
        }
        cursor.close()
        dbHelper.close()
        return cursorCount
    }


    override fun returnTea(context: Context, id: String): String
            = getDatabase(context, id, cursorTea)

    override fun returnCake(context: Context, id: String): String
            = getDatabase(context, id, cursorCake)

    private fun getDatabase(context: Context, id:String, cursorName:String):String{
        val selection = "id = ?"
        val selectionArgs = arrayOf(id)
        dbHelper = DBHelper(context)
        val database = dbHelper.readableDatabase
        val cursor =
            database.query(NAME, null, selection, selectionArgs, null, null, null)
        if (cursor.moveToFirst()) {
            val countIndex = cursor.getColumnIndex(COUNT)
            val teaIndex = cursor.getColumnIndex(TEA)
            val cakeIndex = cursor.getColumnIndex(CAKE)
            do {
                cursorCount = cursor.getString(countIndex)
                cursorTea = cursor.getString(teaIndex)
                cursorCake = cursor.getString(cakeIndex)
            } while (cursor.moveToNext())
        } else {
            cursorCount = "0"
            cursorTea= "0"
            cursorCake = "0"
        }
        cursor.close()
        dbHelper.close()
        return cursorName
    }
}

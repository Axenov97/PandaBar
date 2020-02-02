package com.bignerdanch.pandabar.Model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.bignerdanch.pandabar.Contract.Contract
import com.bignerdanch.pandabar.database.DBHelper
import com.bignerdanch.pandabar.database.PandaDbSchema.PandaTable.Cols.COUNT
import com.bignerdanch.pandabar.database.PandaDbSchema.PandaTable.Cols.ID
import com.bignerdanch.pandabar.database.PandaDbSchema.PandaTable.NAME

class TableModel: Contract.Model {
    lateinit var id: String
    lateinit var dbHelper: DBHelper

    override fun addCount(context: Context, count: String, id: String) {
        dbHelper = DBHelper(context)
        val database = dbHelper.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COUNT, count)
        contentValues.put(ID, id)
        database.insert(NAME, null, contentValues)
        dbHelper.close()
    }

    override fun returnCount(context: Context, id: String): String {
        var cursorCount: String
        var cursorId: String
        var selection: String = "id = ?"
        val selectionArgs = arrayOf(id)

        dbHelper = DBHelper(context)
        val database = dbHelper.writableDatabase
        val cursor =
            database.query(NAME, null, selection, selectionArgs, null, null, null)

        if (cursor.moveToFirst()) {
            val idIndex = cursor.getColumnIndex(ID)
            val countIndex = cursor.getColumnIndex(COUNT)
            do {
                cursorCount = cursor.getString(countIndex)
                cursorId = cursor.getString(idIndex)
            } while (cursor.moveToNext())
        } else cursorCount = "0"

        cursor.close()
        dbHelper.close()
        return cursorCount
    }
}

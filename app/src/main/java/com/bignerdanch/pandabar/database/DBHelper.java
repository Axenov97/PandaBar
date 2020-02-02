package com.bignerdanch.pandabar.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bignerdanch.pandabar.database.PandaDbSchema.PandaTable;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATEBASE_NAME = "pandaBase.db";

    public DBHelper(@Nullable Context context) {
        super(context, DATEBASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + PandaTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                PandaTable.Cols.ID + ", " +
                PandaTable.Cols.COUNT + ", " +
                PandaTable.Cols.TEA + ", " +
                PandaTable.Cols.CAKE + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

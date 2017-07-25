package com.lhyla.todolist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.TabLayout;

/**
 * Created by RENT on 2017-07-25.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ToDoList.db";

    private static final String SQL_CREATE_TABLE = "CREATE TABLE "
            + TableContract.ToDoTable.TABLE_NAME +
            " (" + TableContract.ToDoTable._ID + " INTEGER PRIMARY KEY," +
            TableContract.ToDoTable.COL_TASK_CONTENT + " TEXT," +
            TableContract.ToDoTable.COL_IS_DONE + " INTEGER)";

    public static final String SQL_DROP_TABELE_TODO = "DROP TABLE IF EXISTS "
            + TableContract.ToDoTable.TABLE_NAME;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

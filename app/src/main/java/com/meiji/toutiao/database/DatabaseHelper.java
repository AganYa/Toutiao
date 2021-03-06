package com.meiji.toutiao.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.meiji.toutiao.InitApp;
import com.meiji.toutiao.database.table.NewsChannelTable;

/**
 * Created by Meiji on 2017/3/10.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Toutiao";
    private static final int DB_VERSION = 1;
    private static final String CLEAR_TABLE_DATA = "delete from ";
    private static final String DROP_TABLE = "drop table if exists ";
    private static DatabaseHelper instance = null;
    private static SQLiteDatabase db = null;

    private DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static synchronized DatabaseHelper getInstance() {
        if (instance == null) {
            instance = new DatabaseHelper(InitApp.AppContext, DB_NAME, null, DB_VERSION);
        }
        return instance;
    }

    public static synchronized SQLiteDatabase getDatabase() {
        if (db == null) {
            db = getInstance().getWritableDatabase();
        }
        return db;
    }

    public static synchronized void closeDatabase() {
        if (db != null) {
            db.close();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NewsChannelTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

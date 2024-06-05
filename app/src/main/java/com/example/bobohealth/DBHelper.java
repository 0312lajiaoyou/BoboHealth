package com.example.bobohealth;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 2;
    private static final String DB_NAME = "users.db"; // 创建数据库名叫users
    static final String TB_NAME = "tb_weight"; // 表名

    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建表
        db.execSQL("CREATE TABLE " + TB_NAME + " (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "WEIGHT TEXT, " +
                "DATE TEXT" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion<2){
            db.execSQL("CREATE TABLE " + TB_NAME + " (" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "WEIGHT TEXT, " +
                    "DATE TEXT" +
                    ")");
        }

    }
}

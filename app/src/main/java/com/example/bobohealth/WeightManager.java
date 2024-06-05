package com.example.bobohealth;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class WeightManager {
    private DBHelper dbHelper;
    private String TBNAME1;

    public WeightManager(Context context) {
        dbHelper = new DBHelper(context);
        TBNAME1 = DBHelper.TB_NAME;
    }

    public void add(WeightItem item) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("WEIGHT", item.getweight());
        values.put("DATE", item.getdate());
        db.insert(TBNAME1, null, values);
        db.close();
    }

    public void delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME1,"ID=?",new String[]{String.valueOf(id)});
        db.close();
    }
}

package com.example.project2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "book.db";
    private static final int DATABASE_VERSION = 2;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
//TODO Auto-generade method stub
        String sql = "create table biodata(id_b integer primary key,title text null, writer text null,synopsis text null,availability text null);";
        Log.d("Data","onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO biodata (id_b,title,writer,synopsis,availability) VALUES ('1001','Harry Potter','J.K. Rowling','A boy who lived come to die','Not Available');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1,int arg2) {
//TODO Auto-generated method stub
    }
}
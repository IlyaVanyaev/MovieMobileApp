package com.example.moviemaster.SQLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "clients.db";
    static final int DATABASE_VERSION = 1;

    public DataBaseHelper(@Nullable Context context) {
        super(context, "clients.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create Table users(username TEXT primary key, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("drop Table if exists users");

    }

    public Boolean insertData(String userName, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", userName);
        contentValues.put("password", password);
        long result = sqLiteDatabase.insert("users", null, contentValues);

        return result != -1;
    }


    public Boolean checkUserName(String userName){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = sqLiteDatabase.rawQuery("Select * from users where username = ?", new String[]{userName});

        return cursor.getCount() > 0;
    }


    public Boolean checkUserNamePassword(String userName, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = sqLiteDatabase.rawQuery("Select * from users where username = ? and password = ?", new String[]{userName, password});

        return cursor.getCount() > 0;
    }

}

package com.group1.LopCSDL;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class XuLyDatabase extends SQLiteOpenHelper {

    public XuLyDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void khongTraKQ(String kq){
        SQLiteDatabase database = getWritableDatabase();

        database.execSQL(kq);

    }

    public Cursor traVeKQ(String kq){

        SQLiteDatabase database = getReadableDatabase();

        return database.rawQuery(kq, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

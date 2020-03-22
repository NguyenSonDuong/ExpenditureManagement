package com.group1.LopCSDL;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class XuLyDatabase extends SQLiteOpenHelper {

    Context context;
    String name;
    public XuLyDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
        this.name = name;
    }

    public void khongTraKQ(String kq){
        SQLiteDatabase database = getWritableDatabase(); // UPDATE-INSER-DELETE
        database.execSQL(kq);
    }

    public Cursor traVeKQ(String kq){
        SQLiteDatabase database = getReadableDatabase(); // SELECT
        return database.rawQuery(kq, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if(name.equals(KeyDatabase.DATABASENAME)){
            db.execSQL("CREATE TABLE IF NOT EXISTS "+KeyDatabase.TABLENAME_NGUOIDUNG+" (nickName VARCHAR(200) PRIMARY KEY," +
                    "Email VARCHAR(200), " +
                    "GioiTinh INTEGER, " +
                    "ngaySinh DATETIME, " +
                    "PassWord VARCAR(100), " +
                    "Create_time DATETIME)");
            return;
        }
        db.execSQL("CREATE TABLE IF NOT EXISTS "+KeyDatabase.TABLENAME_CHITIEU+" (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "soTien DOUBLE, " +
                "loaiGiaoDich VARCHAR(200), " +
                "ghiChuGiaoDich VARCHAR(150), " +
                "thoiGianGiaoDich DATETIME, " +
                "diaDiem VARCHAR(200), " +
                "soLuong INTERGER)");
        db.execSQL("CREATE TABLE IF NOT EXISTS "+KeyDatabase.TABLENAME_VAY+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "soTienVay DOUBLE, " +
                "soTienTra DOUBLE, " +
                "hantra DATETIME,"+
                "nguoiGiaoDich VARCHAR(100), " +
                "loaiGiaoDich VARCHAR(200), " +
                "ghiChuGiaoDich VARCHAR(100), " +
                "thoiGianGiaoDich DATETIME, " +
                "laiSuat FLOAT, " +
                "trangThai VARCHAR(100))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

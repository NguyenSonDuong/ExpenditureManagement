package com.group1.LopCSDL;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class HoTroXuLyDataBase {

    int tam = 0;
    public static void ttNguoiDung(XuLyDatabase xuLyDatabase,Context context,String namedatabase){
        if(xuLyDatabase == null){
            xuLyDatabase = new XuLyDatabase(context, namedatabase, null, 1);
        }
        xuLyDatabase.khongTraKQ("CREATE TABLE IF NOT EXISTS NguoiDung (nickName VARCHAR(200) PRIMARY KEY," +
                "Email VARCHAR(200), " +
                "GioiTinh INTEGER, " +
                "ngaySinh DATETIME, " +
                "PassWordl VARCAR(100), " +
                "Create_time DATETIME)");

        //xuLyDatabase.traVeKQ("INSERT INTO NguoiDung VALUES()");
        //xuLyDatabase.traVeKQ("SELECT * FROM NguoiDung Where nicknam = '"+etdhf+"'and pashdfg = '"+pass+"'");
    }

    public static void ttChiTieu(XuLyDatabase xuLyDatabase,Context context,String namedatabase){
        if(xuLyDatabase == null){
            xuLyDatabase = new XuLyDatabase(context, namedatabase, null, 1);
        }

        xuLyDatabase.khongTraKQ("CREATE TABLE IF NOT EXISTS ChiTieu (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "soTien DOUBLE, " +
                "loaiGiaoDich VARCHAR(200), " +
                "ghiChuGiaoDich VARCHAR(150), " +
                "thoiGianGiaoDich DATETIME, " +
                "diaDiem VARCHAR(200))");
    }

    public static void ttVayTra(XuLyDatabase xuLyDatabase,Context context,String namedatabase){
        if(xuLyDatabase == null){
            xuLyDatabase = new XuLyDatabase(context, namedatabase, null, 1);
        }
        xuLyDatabase.khongTraKQ("CREATE TABLE IF NOT EXISTS VayTra (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "soTienVay DOUBLE, " +
                "soTienTra DOUBLE, " +
                "nguoiGiaoDich VARCHAR(100), " +
                "loaiGiaoDich VARCHAR(200), " +
                "ghiChuGiaoDich VARCHAR(100), " +
                "thoiGianGiaoDich DATETIME, " +
                "laiSuat FLOAT, " +
                "trangThai VARCHAR(100))");
    }






}

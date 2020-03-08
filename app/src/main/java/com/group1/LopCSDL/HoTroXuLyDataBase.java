package com.group1.LopCSDL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class HoTroXuLyDataBase {
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
        //xuLyDatabase.traVeKQ("SELECT * FROM NguoiDung Where ");
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

    public static void themDLNguoiDung(XuLyDatabase xuLyDatabase, String nickName, String email, double gioiTinh, String ngaySinh, String passWordl, String Create_time){

        String themDLND = "INSERT INTO NguoiDung VALUES(?, ?, ?, ?, ? ,?)";

        SQLiteStatement sqLiteStatement = xuLyDatabase.getWritableDatabase().compileStatement(themDLND);

        //xóa đi phần tử đã có dl
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1, nickName);
        sqLiteStatement.bindString(2, email);
        sqLiteStatement.bindDouble(3, gioiTinh);
        sqLiteStatement.bindString(4, ngaySinh);
        sqLiteStatement.bindString(5, passWordl);
        sqLiteStatement.bindString(6,  Create_time);

        sqLiteStatement.executeInsert();

    }

    public static void themDLChiTieu(XuLyDatabase xuLyDatabase, int id, double soTien, String loaiGiaoDich, String ghiChuGiaoDich, String thoiGianGiaoDich, String diaDiem){

        String themDLChiTieu = "INSERT INTO ChiTieu VALUES (NULL, ?, ?, ?, ?, ?)";

        SQLiteStatement sqLiteStatement = xuLyDatabase.getWritableDatabase().compileStatement(themDLChiTieu);

        sqLiteStatement.clearBindings();

        sqLiteStatement.bindDouble(1, soTien);
        sqLiteStatement.bindString(2, loaiGiaoDich);
        sqLiteStatement.bindString(3, ghiChuGiaoDich);
        sqLiteStatement.bindString(4, thoiGianGiaoDich);
        sqLiteStatement.bindString(5, diaDiem);

        sqLiteStatement.executeInsert();
    }

    public static void themDLVayTra(XuLyDatabase xuLyDatabase, int id, double soTienVay, double soTienTra, String nguoiGiaoDich, String loaiGiaoDich, String ghiChuGiaoDich, String thoiGianGiaoDich, float laiSuat, String trangThai){

       String themDLVayTra = "INSERT INTO VayTra VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?)";

       SQLiteStatement sqLiteStatement = xuLyDatabase.getWritableDatabase().compileStatement(themDLVayTra);

       sqLiteStatement.clearBindings();

       sqLiteStatement.bindDouble(1, soTienVay);
       sqLiteStatement.bindDouble(2, soTienTra);
       sqLiteStatement.bindString(3, nguoiGiaoDich);
       sqLiteStatement.bindString(4, loaiGiaoDich);
       sqLiteStatement.bindString(5, ghiChuGiaoDich);
       sqLiteStatement.bindString(6, thoiGianGiaoDich);
       sqLiteStatement.bindDouble(7, laiSuat);
       sqLiteStatement.bindString(8, trangThai);

       sqLiteStatement.executeInsert();
    }

    public static void dlDangNhap(){

    }
}

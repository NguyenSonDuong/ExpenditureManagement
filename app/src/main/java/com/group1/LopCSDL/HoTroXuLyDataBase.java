package com.group1.LopCSDL;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import android.widget.Toast;

import com.group1.expendituremanagement.DangNhap;
import com.group1.expendituremanagement.MainActivity;

import java.util.ArrayList;

public class HoTroXuLyDataBase {

    int tam = 0;

    public HoTroXuLyDataBase() {
    }


    public static boolean loginCheck(Context context,String nickname, String password){
        XuLyDatabase xuLyDatabase = new XuLyDatabase(context, KeyDatabase.DATABASENAME,null, 1);
        Cursor cursor = xuLyDatabase.traVeKQ("SELECT * FROM "+KeyDatabase.TABLENAME_NGUOIDUNG+" WHERE nickName = '"+nickname+"' AND PassWord = '"+password+"'");
        if(cursor.getCount() != 1){
            return false;
        }else {
            return true;
        }
    }
//    public static boolean registerCheck(Context context,String... data){
//
//    }
    public static void ttNguoiDung(XuLyDatabase xuLyDatabase, Context context, String namedatabase){
        if(xuLyDatabase == null){
            xuLyDatabase = new XuLyDatabase(context, namedatabase, null, 1);
        }
        xuLyDatabase.khongTraKQ("CREATE TABLE IF NOT EXISTS NguoiDung (nickName VARCHAR(200) PRIMARY KEY," +
                "Email VARCHAR(200), " +
                "GioiTinh INTEGER, " +
                "ngaySinh DATETIME, " +
                "PassWord VARCAR(100), " +
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
                "diaDiem VARCHAR(200), " +
                "soLuong INTERGER)");
    }

    public static void ttVayTra(XuLyDatabase xuLyDatabase,Context context,String namedatabase){
        if(xuLyDatabase == null){
            xuLyDatabase = new XuLyDatabase(context, namedatabase, null, 1);
        }
        xuLyDatabase.khongTraKQ("CREATE TABLE IF NOT EXISTS VayTra (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "soTienVay DOUBLE, " +
                "soTienTra DOUBLE, " +
                "hantra DATETIME"+
                "nguoiGiaoDich VARCHAR(100), " +
                "loaiGiaoDich VARCHAR(200), " +
                "ghiChuGiaoDich VARCHAR(100), " +
                "thoiGianGiaoDich DATETIME, " +
                "laiSuat FLOAT, " +
                "trangThai VARCHAR(100))");
    }
    public static boolean registerUserSQLLite(XuLyDatabase xuLyDatabase, String nickName, String passWordl, String email, int gioiTinh, String ngaySinh){
        String themDLND = "INSERT INTO "+KeyDatabase.TABLENAME_NGUOIDUNG+" VALUES(?, ?, ?, ?, ? ,?)";
        try{
            SQLiteStatement sqLiteStatement = xuLyDatabase.getWritableDatabase().compileStatement(themDLND);
            //xóa đi phần đã phân tích dl
            sqLiteStatement.clearBindings();
            sqLiteStatement.bindString(1, nickName);
            sqLiteStatement.bindString(2, email);
            sqLiteStatement.bindDouble(3, (double) gioiTinh);
            sqLiteStatement.bindString(4, ngaySinh);
            sqLiteStatement.bindString(5, passWordl);
            sqLiteStatement.bindString(6,  LopCreat_Time.TongHopThoiGian());
            sqLiteStatement.executeInsert();
            return true;
        }catch (Exception ex){
            Log.d("REGISTERUSERSQLLITE", "registerUserSQLLite: "+ex.getMessage());
            return false;
        }


    }

    public static boolean themDLChiTieu(XuLyDatabase xuLyDatabase, int id, double soTien, String loaiGiaoDich, String ghiChuGiaoDich, String thoiGianGiaoDich, String diaDiem, int soLuong){

        String themDLChiTieu = "INSERT INTO "+KeyDatabase.TABLENAME_CHITIEU+" VALUES (NULL, ?, ?, ?, ?, ?)";
        try {
            SQLiteStatement sqLiteStatement = xuLyDatabase.getWritableDatabase().compileStatement(themDLChiTieu);

            sqLiteStatement.clearBindings();

            sqLiteStatement.bindDouble(1, soTien);
            sqLiteStatement.bindString(2, loaiGiaoDich);
            sqLiteStatement.bindString(3, ghiChuGiaoDich);
            sqLiteStatement.bindString(4, thoiGianGiaoDich);
            sqLiteStatement.bindString(5, diaDiem);
            sqLiteStatement.bindLong(6, soLuong);

            sqLiteStatement.executeInsert();

            return  true;
        }catch (Exception ex){
            Log.d("themDLChiTieu", "onClick: " +ex.getMessage());
            return false;
        }



    }

    public static boolean themDLVayTra(XuLyDatabase xuLyDatabase, int id, double soTienVay, double soTienTra, String hanTra, String nguoiGiaoDich, String loaiGiaoDich, String ghiChuGiaoDich, String thoiGianGiaoDich, float laiSuat, String trangThai){

        String themDLVayTra = "INSERT INTO "+KeyDatabase.TABLENAME_CHITIEU+" VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            SQLiteStatement sqLiteStatement = xuLyDatabase.getWritableDatabase().compileStatement(themDLVayTra);

            sqLiteStatement.clearBindings();

            sqLiteStatement.bindDouble(1, soTienVay);
            sqLiteStatement.bindDouble(2, soTienTra);
            sqLiteStatement.bindString(3, hanTra);
            sqLiteStatement.bindString(4, nguoiGiaoDich);
            sqLiteStatement.bindString(5, loaiGiaoDich);
            sqLiteStatement.bindString(6, ghiChuGiaoDich);
            sqLiteStatement.bindString(7, thoiGianGiaoDich);
            sqLiteStatement.bindDouble(8, laiSuat);
            sqLiteStatement.bindString(9, trangThai);

            sqLiteStatement.executeInsert();

            return true;
        }catch (Exception e){
            Log.d("themDLVayTra", "onClick: " +e.getMessage());
            return false;
        }
    }

    public static ArrayList<ThongTinChiTieu> layDLChiTieu(XuLyDatabase xuLyDatabase){
        ArrayList<ThongTinChiTieu> arrayList = new ArrayList<>();
        Cursor cursor = xuLyDatabase.traVeKQ("SELECT * FROM "+KeyDatabase.TABLENAME_CHITIEU);

        while (cursor.moveToNext()){
            ThongTinChiTieu thongTinChiTieuu = new ThongTinChiTieu();

            thongTinChiTieuu.setId(cursor.getInt(0));
            thongTinChiTieuu.setSoTien(cursor.getDouble(1));
            thongTinChiTieuu.setLoaiGiaoDich(cursor.getString(2));
            thongTinChiTieuu.setGhiChuGiaoDich(cursor.getString(3));
            thongTinChiTieuu.setThoiGianGiaoDich(cursor.getString(4));
            thongTinChiTieuu.setDiaDiem(cursor.getString(5));
            thongTinChiTieuu.setSoLuong(cursor.getInt(6));

            arrayList.add(thongTinChiTieuu);
        }

        return arrayList;
    }

    public static ArrayList<ThongTinVayTra> layDLVayTra(XuLyDatabase xuLyDatabase){
        ArrayList<ThongTinVayTra> arrayList = new ArrayList<>();

        Cursor cursor = xuLyDatabase.traVeKQ("SELECT * FROM "+KeyDatabase.TABLENAME_VAY);

        while (cursor.moveToNext()){
            ThongTinVayTra thongTinVayTraa = new ThongTinVayTra();


            thongTinVayTraa.setId(cursor.getInt(0));
            thongTinVayTraa.setSoTienVay(cursor.getDouble(1));
            thongTinVayTraa.setSoTienTra(cursor.getDouble(2));
            thongTinVayTraa.setNguoiGiaoDich(cursor.getString(3));
            thongTinVayTraa.setLoaiGiaoDich(cursor.getString(4));
            thongTinVayTraa.setGhiChuGiaoDich(cursor.getString(5));
            thongTinVayTraa.setThoiGianGiaoDich(cursor.getString(6));
            thongTinVayTraa.setLaiSuat(cursor.getDouble(7));
            thongTinVayTraa.setTrangThai(cursor.getString(8));

            arrayList.add(thongTinVayTraa);
        }

        return arrayList;
    }

    public static int SuaDL(XuLyDatabase xuLyDatabase, ThongTinChiTieu thongTinChiTieu, ThongTinVayTra thongTinVayTra, String Table_Name, int id){

        try {
            SQLiteDatabase database = xuLyDatabase.getWritableDatabase();

            if(Table_Name == KeyDatabase.TABLENAME_CHITIEU){

                ContentValues contentValues = new ContentValues();

                contentValues.put("soTien", thongTinChiTieu.getSoTien());
                contentValues.put("loaiGiaoDich", thongTinChiTieu.getLoaiGiaoDich());
                contentValues.put("ghiChuGiaoDich", thongTinChiTieu.getGhiChuGiaoDich());
                contentValues.put("thoiGianGiaoDich", thongTinChiTieu.getThoiGianGiaoDich());
                contentValues.put("diaDiem", thongTinChiTieu.getDiaDiem());
                contentValues.put("soLuong", thongTinChiTieu.getSoLuong());

                return database.update(KeyDatabase.TABLENAME_CHITIEU, contentValues, "ID" + " = ?", new String[]{String.valueOf(id)});

            }else if (Table_Name == KeyDatabase.TABLENAME_VAY){


                ContentValues contentValues = new ContentValues();

                contentValues.put("soTienVay", thongTinVayTra.getSoTienVay());
                contentValues.put("soTienTra", thongTinVayTra.getSoTienTra());
                contentValues.put("hantra", thongTinVayTra.getHanTra());
                contentValues.put("nguoiGiaoDich", thongTinVayTra.getNguoiGiaoDich());
                contentValues.put("loaiGiaoDich", thongTinVayTra.getLoaiGiaoDich());
                contentValues.put("ghiChuGiaoDich", thongTinVayTra.getGhiChuGiaoDich());
                contentValues.put("thoiGianGiaoDich", thongTinVayTra.getThoiGianGiaoDich());
                contentValues.put("laiSuat", thongTinVayTra.getLaiSuat());
                contentValues.put("trangThai", thongTinVayTra.getTrangThai());

                return database.update(KeyDatabase.TABLENAME_VAY, contentValues, "ID" + "= ?", new String[]{String.valueOf(id)});
            }

        }catch (Exception ex){
            Log.d("TAG", "SuaDL: "+ex.getMessage());
            return 0;
        }
        return 0;
    }


    public int xoaDL(XuLyDatabase xuLyDatabase, String Table_Name, int id){

        try {
            SQLiteDatabase database = xuLyDatabase.getWritableDatabase();

            if(Table_Name == KeyDatabase.TABLENAME_CHITIEU){

                return database.delete(KeyDatabase.TABLENAME_CHITIEU, "ID" + " = ?", new String[]{id +""});

            }else if(Table_Name == KeyDatabase.TABLENAME_VAY){

                return database.delete(KeyDatabase.TABLENAME_VAY, "ID" + " = ?", new String[]{id +""});
            }
        }catch (Exception ex){
            Log.d("TAG", "xoaDL: "+ex.getMessage());
        }
        return 0;
    }

}

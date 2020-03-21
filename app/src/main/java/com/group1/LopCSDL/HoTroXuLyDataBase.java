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
//    public static void ttNguoiDung(XuLyDatabase xuLyDatabase, Context context, String namedatabase){
//        if(xuLyDatabase == null){
//            xuLyDatabase = new XuLyDatabase(context, namedatabase, null, 1);
//        }
//        xuLyDatabase.khongTraKQ("CREATE TABLE IF NOT EXISTS NguoiDung (nickName VARCHAR(200) PRIMARY KEY," +
//                "Email VARCHAR(200), " +
//                "GioiTinh INTEGER, " +
//                "ngaySinh DATETIME, " +
//                "PassWord VARCAR(100), " +
//                "Create_time DATETIME)");
//
//        //xuLyDatabase.traVeKQ("INSERT INTO NguoiDung VALUES()");
//        //xuLyDatabase.traVeKQ("SELECT * FROM NguoiDung Where nicknam = '"+etdhf+"'and pashdfg = '"+pass+"'");
//    }
//
//    public static void ttChiTieu(XuLyDatabase xuLyDatabase,Context context,String namedatabase){
//        if(xuLyDatabase == null){
//            xuLyDatabase = new XuLyDatabase(context, namedatabase, null, 1);
//        }
//
//        xuLyDatabase.khongTraKQ("CREATE TABLE IF NOT EXISTS ChiTieu (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
//                "soTien DOUBLE, " +
//                "loaiGiaoDich VARCHAR(200), " +
//                "ghiChuGiaoDich VARCHAR(150), " +
//                "thoiGianGiaoDich DATETIME, " +
//                "diaDiem VARCHAR(200), " +
//                "soLuong INTERGER)");
//    }
//
//    public static void ttVayTra(XuLyDatabase xuLyDatabase,Context context,String namedatabase){
//        if(xuLyDatabase == null){
//            xuLyDatabase = new XuLyDatabase(context, namedatabase, null, 1);
//        }
//        xuLyDatabase.khongTraKQ("CREATE TABLE IF NOT EXISTS VayTra (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "soTienVay DOUBLE, " +
//                "soTienTra DOUBLE, " +
//                "hantra DATETIME"+
//                "nguoiGiaoDich VARCHAR(100), " +
//                "loaiGiaoDich VARCHAR(200), " +
//                "ghiChuGiaoDich VARCHAR(100), " +
//                "thoiGianGiaoDich DATETIME, " +
//                "laiSuat FLOAT, " +
//                "trangThai VARCHAR(100))");
//    }

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

    public static boolean addChiTieu(XuLyDatabase xuLyDatabase, ThongTinChiTieu chiTieu){
        String themDLChiTieu = "INSERT INTO "+KeyDatabase.TABLENAME_CHITIEU+" VALUES (NULL, ?, ?, ?, ?, ?,?)";
        try {
            SQLiteStatement sqLiteStatement = xuLyDatabase.getWritableDatabase().compileStatement(themDLChiTieu);
            sqLiteStatement.clearBindings();
            sqLiteStatement.bindDouble(1, chiTieu.getSoTien());
            sqLiteStatement.bindString(2, chiTieu.getLoaiGiaoDich());
            sqLiteStatement.bindString(3, chiTieu.getGhiChuGiaoDich());
            sqLiteStatement.bindString(4, chiTieu.getThoiGianGiaoDich());
            sqLiteStatement.bindString(5, chiTieu.getDiaDiem());
            sqLiteStatement.bindLong(6, chiTieu.getSoLuong());
            sqLiteStatement.executeInsert();
            return  true;
        }catch (Exception ex){
            Log.d("themDLChiTieu", "onClick: " +ex.getMessage());
            return false;
        }
    }

    public static boolean addVayTra(XuLyDatabase xuLyDatabase, ThongTinVayTra vayTra){
        String themDLVayTra = "INSERT INTO "+KeyDatabase.TABLENAME_VAY+" VALUES( NULL,?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            SQLiteStatement sqLiteStatement = xuLyDatabase.getWritableDatabase().compileStatement(themDLVayTra);
            sqLiteStatement.clearBindings();
            sqLiteStatement.bindDouble(1, vayTra.getSotienvay());
            sqLiteStatement.bindDouble(2, vayTra.getSotiendatra());
            sqLiteStatement.bindString(3, vayTra.getHantra());
            sqLiteStatement.bindString(4, vayTra.getNguoigiaodich());
            sqLiteStatement.bindString(5, vayTra.getLoaigiaodich());
            sqLiteStatement.bindString(6, vayTra.getGhichugiaodich());
            sqLiteStatement.bindString(7, vayTra.getThoigiangiaodich());
            sqLiteStatement.bindDouble(8, vayTra.getLaisuat());
            sqLiteStatement.bindString(9, vayTra.getTrangthai());
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
    public static ArrayList<ThongTinChiTieu> layDLChiTieuByLoaiChiTieu(XuLyDatabase xuLyDatabase, String loaigiaodich){
        ArrayList<ThongTinChiTieu> arrayList = new ArrayList<>();
        Cursor cursor = xuLyDatabase.traVeKQ("SELECT * FROM "+KeyDatabase.TABLENAME_CHITIEU + " WHERE loaiGiaoDich = '"+loaigiaodich+"'");
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

    public static ArrayList<LoaiChiTieu> getThongLoaiChiTieu(XuLyDatabase xuLyDatabase,ArrayList<String> loaiGD){
        ArrayList<LoaiChiTieu> list = new ArrayList<>();
        Log.d("TAG", "ArrayListString: "+loaiGD.size());
        for (String item : loaiGD){
            ArrayList<ThongTinChiTieu> listDS = layDLChiTieuByLoaiChiTieu(xuLyDatabase,item);
            Log.d("TAG", "layDLChiTieuByLoaiChiTieu: "+listDS.size());
            LoaiChiTieu loaiChiTieu = new LoaiChiTieu();
            loaiChiTieu.loaichitieu = item;
            long money =0;
            for (ThongTinChiTieu item2 : listDS){
                money += item2.getSoTien();
                loaiChiTieu.end_buy_time = item2.getThoiGianGiaoDich();
            }
            loaiChiTieu.sotien = money;
            list.add(loaiChiTieu);
        }
        Log.d("TAG", "ArrayList<LoaiChiTieu>: "+list.size());
        return list;
    }

    public static ArrayList<ThongTinVayTra> layDLVayTra(XuLyDatabase xuLyDatabase){
        ArrayList<ThongTinVayTra> arrayList = new ArrayList<>();

        Cursor cursor = xuLyDatabase.traVeKQ("SELECT * FROM "+KeyDatabase.TABLENAME_VAY);

        while (cursor.moveToNext()){
            ThongTinVayTra thongTinVayTraa = new ThongTinVayTra();


            thongTinVayTraa.setId(cursor.getInt(0));
            thongTinVayTraa.setSotienvay((long) cursor.getDouble(1));
            thongTinVayTraa.setSotiendatra((long) cursor.getDouble(2));
            thongTinVayTraa.setHantra(cursor.getString(3));
            thongTinVayTraa.setNguoigiaodich(cursor.getString(4));
            thongTinVayTraa.setLoaigiaodich(cursor.getString(5));
            thongTinVayTraa.setGhichugiaodich(cursor.getString(6));
            thongTinVayTraa.setThoigiangiaodich(cursor.getString(7));
            thongTinVayTraa.setLaisuat((long) cursor.getDouble(8));
            thongTinVayTraa.setTrangthai(cursor.getString(9));

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

                contentValues.put("soTienVay", thongTinVayTra.getSotienvay());
                contentValues.put("soTienTra", thongTinVayTra.getSotiendatra());
                contentValues.put("hantra", thongTinVayTra.getHantra());
                contentValues.put("nguoiGiaoDich", thongTinVayTra.getNguoigiaodich());
                contentValues.put("loaiGiaoDich", thongTinVayTra.getLoaigiaodich());
                contentValues.put("ghiChuGiaoDich", thongTinVayTra.getGhichugiaodich());
                contentValues.put("thoiGianGiaoDich", thongTinVayTra.getThoigiangiaodich());
                contentValues.put("laiSuat", thongTinVayTra.getLaisuat());
                contentValues.put("trangThai", thongTinVayTra.getTrangthai());

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

package com.group1.expendituremanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.group1.LopCSDL.ThongTinChiTieu;
import com.group1.LopCSDL.ThongTinNguoiDung;
import com.group1.LopCSDL.ThongTinVayTra;
import com.group1.LopCSDL.XuLyDatabase;

public class MainActivity extends AppCompatActivity {

    ThongTinChiTieu chiTieu;
    ThongTinVayTra vayTra;
    ThongTinNguoiDung nguoiDung;
    XuLyDatabase xuLyDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ttNguoiDung();
        ttChiTieu();
        ttVayTra();

    }

    public void ttNguoiDung(){
        xuLyDatabase = new XuLyDatabase(this, "dlNguoiDung.sqlite", null, 1);

        xuLyDatabase.khongTraKQ("CREATE TABLE IF NOT EXISTS NguoiDung (nickName VARCHAR(200) PRIMARY KEY," +
                                                                        "Email VARCHAR(200), " +
                                                                        "GioiTinh INTEGER, " +
                                                                        "ngaySinh DATETIME, " +
                                                                        "PassWordl VARCAR(100), " +
                                                                        "Create_time DATETIME)");

        //xuLyDatabase.traVeKQ("INSERT INTO NguoiDung VALUES()");
        //xuLyDatabase.traVeKQ("SELECT * FROM NguoiDung Where ");
    }

    public void ttChiTieu(){
        xuLyDatabase = new XuLyDatabase(this, "dlChiTieu.slqtite", null, 1);

        xuLyDatabase.khongTraKQ("CREATE TABLE IF NOT EXISTS ChiTieu (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                                    "soTien DOUBLE, " +
                                                                    "loaiGiaoDich VARCHAR(200), " +
                                                                    "ghiChuGiaoDich VARCHAR(150), " +
                                                                    "ngayGiaoDich DATETIME)");
    }

    public void ttVayTra(){
        xuLyDatabase = new XuLyDatabase(this, "dlVayTra.slqtite", null, 1);

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

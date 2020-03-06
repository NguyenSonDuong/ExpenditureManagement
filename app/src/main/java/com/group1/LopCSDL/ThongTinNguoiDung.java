package com.group1.LopCSDL;

import android.database.sqlite.SQLiteOpenHelper;

public class ThongTinNguoiDung {
    private String nickName;
    private String email;
    private int gioiTinh;
    private String ngaySinh;
    private String passWordl;
    private String Create_time;

    public ThongTinNguoiDung() {
    }

    public ThongTinNguoiDung(String nickName, String email, int gioiTinh, String ngaySinh, String passWordl, String create_time) {
        this.nickName = nickName;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.passWordl = passWordl;
        Create_time = create_time;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getPassWordl() {
        return passWordl;
    }

    public void setPassWordl(String passWordl) {
        this.passWordl = passWordl;
    }

    public String getCreate_time() {
        return Create_time;
    }

    public void setCreate_time(String create_time) {
        Create_time = create_time;
    }
}

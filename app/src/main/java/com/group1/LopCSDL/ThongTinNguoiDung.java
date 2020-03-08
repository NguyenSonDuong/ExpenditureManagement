package com.group1.LopCSDL;

<<<<<<< HEAD
import android.database.sqlite.SQLiteOpenHelper;

public class ThongTinNguoiDung {
    private String nickName;
    private String email;
    private int gioiTinh;
    private String ngaySinh;
    private String passWordl;
    private String Create_time;
=======
public class ThongTinNguoiDung {
    private String nickName;
    private String email;
    private double gioiTinh;
    private String ngaySinh;
    private String passWordl;
    private LopCreat_Time Create_time;
>>>>>>> c24cf1a70906cb14cb882e393002a845aa71bd0c

    public ThongTinNguoiDung() {
    }

<<<<<<< HEAD
    public ThongTinNguoiDung(String nickName, String email, int gioiTinh, String ngaySinh, String passWordl, String create_time) {
=======
    public ThongTinNguoiDung(String nickName, String email, double gioiTinh, String ngaySinh, String passWordl, LopCreat_Time create_time) {
>>>>>>> c24cf1a70906cb14cb882e393002a845aa71bd0c
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

<<<<<<< HEAD
    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
=======
    public double getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(double gioiTinh) {
>>>>>>> c24cf1a70906cb14cb882e393002a845aa71bd0c
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

<<<<<<< HEAD
    public String getCreate_time() {
        return Create_time;
    }

    public void setCreate_time(String create_time) {
=======
    public LopCreat_Time getCreate_time() {
        return Create_time;
    }

    public void setCreate_time(LopCreat_Time create_time) {
>>>>>>> c24cf1a70906cb14cb882e393002a845aa71bd0c
        Create_time = create_time;
    }
}

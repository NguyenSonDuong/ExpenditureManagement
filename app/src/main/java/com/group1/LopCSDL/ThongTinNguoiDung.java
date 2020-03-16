package com.group1.LopCSDL;

public class ThongTinNguoiDung {
    private String nickName;
    private String email;
    private double gioiTinh;
    private String ngaySinh;
    private String passWord;
    private LopCreat_Time Create_time;

    public ThongTinNguoiDung() {
    }

    public ThongTinNguoiDung(String nickName, String email, double gioiTinh, String ngaySinh, String passWord, LopCreat_Time create_time) {
        this.nickName = nickName;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.passWord = passWord;
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

    public double getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(double gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public LopCreat_Time getCreate_time() {
        return Create_time;
    }

    public void setCreate_time(LopCreat_Time create_time) {
        Create_time = create_time;
    }
}

package com.group1.LopCSDL;

public class ThongTinVayTra {

    private int id;
    private double soTienVay;
    private double soTienTra;
    private String nguoiGiaoDich;
    private String ghiChuGiaoDich;
    private String thoiGianGiaoDich;
    private float laiSuat;
    private String trangThai;

    public ThongTinVayTra() {
    }

    public ThongTinVayTra(int id, double soTienVay, double soTienTra, String nguoiGiaoDich, String ghiChuGiaoDich, String thoiGianGiaoDich, float laiSuat, String trangThai) {
        this.id = id;
        this.soTienVay = soTienVay;
        this.soTienTra = soTienTra;
        this.nguoiGiaoDich = nguoiGiaoDich;
        this.ghiChuGiaoDich = ghiChuGiaoDich;
        this.thoiGianGiaoDich = thoiGianGiaoDich;
        this.laiSuat = laiSuat;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSoTienVay() {
        return soTienVay;
    }

    public void setSoTienVay(double soTienVay) {
        this.soTienVay = soTienVay;
    }

    public double getSoTienTra() {
        return soTienTra;
    }

    public void setSoTienTra(double soTienTra) {
        this.soTienTra = soTienTra;
    }

    public String getNguoiGiaoDich() {
        return nguoiGiaoDich;
    }

    public void setNguoiGiaoDich(String nguoiGiaoDich) {
        this.nguoiGiaoDich = nguoiGiaoDich;
    }

    public String getGhiChuGiaoDich() {
        return ghiChuGiaoDich;
    }

    public void setGhiChuGiaoDich(String ghiChuGiaoDich) {
        this.ghiChuGiaoDich = ghiChuGiaoDich;
    }

    public String getThoiGianGiaoDich() {
        return thoiGianGiaoDich;
    }

    public void setThoiGianGiaoDich(String thoiGianGiaoDich) {
        this.thoiGianGiaoDich = thoiGianGiaoDich;
    }

    public float getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(float laiSuat) {
        this.laiSuat = laiSuat;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}

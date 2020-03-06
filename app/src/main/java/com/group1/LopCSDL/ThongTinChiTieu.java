package com.group1.LopCSDL;

public class ThongTinChiTieu {

    private int id;
    private double soTien;
    private String loaiGiaoDich;
    private String ghiChuGiaoDich;
    private String thoiGianGiaoDich;
    private String diaDiem;

    public ThongTinChiTieu() {
    }

    public ThongTinChiTieu(int id, double soTien, String loaiGiaoDich, String ghiChuGiaoDich, String thoiGianGiaoDich, String diaDiem) {
        this.id = id;
        this.soTien = soTien;
        this.loaiGiaoDich = loaiGiaoDich;
        this.ghiChuGiaoDich = ghiChuGiaoDich;
        this.thoiGianGiaoDich = thoiGianGiaoDich;
        this.diaDiem = diaDiem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public String getLoaiGiaoDich() {
        return loaiGiaoDich;
    }

    public void setLoaiGiaoDich(String loaiGiaoDich) {
        this.loaiGiaoDich = loaiGiaoDich;
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

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }
}

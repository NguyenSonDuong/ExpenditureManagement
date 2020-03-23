package com.group1.LopCSDL;

public class LoaiVayTra {

    private String loaiVayTra;
    private double soTien;
    private String ghiChu;

    public LoaiVayTra() {
    }

    public LoaiVayTra(String loaiVayTra, double soTien, String ghiChu) {
        this.loaiVayTra = loaiVayTra;
        this.soTien = soTien;
        this.ghiChu = ghiChu;
    }

    public String getLoaiVayTra() {
        return loaiVayTra;
    }

    public void setLoaiVayTra(String loaiVayTra) {
        this.loaiVayTra = loaiVayTra;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}

package com.group1.LopCSDL;

public class ThongTinVayTra {

    private int id;
    private double soTienVay;
    private double soTienTra;
    private String nguoiGiaoDich;
    private String loaiGiaoDich;
    private String ghiChuGiaoDich;
    private String thoiGianGiaoDich;
<<<<<<< HEAD
    private float laiSuat;
=======
    private double laiSuat;
>>>>>>> c24cf1a70906cb14cb882e393002a845aa71bd0c
    private String trangThai;

    public ThongTinVayTra() {
    }

<<<<<<< HEAD
    public ThongTinVayTra(int id, double soTienVay, double soTienTra, String nguoiGiaoDich, String loaiGiaoDich, String ghiChuGiaoDich, String thoiGianGiaoDich, float laiSuat, String trangThai) {
=======
    public ThongTinVayTra(int id, double soTienVay, double soTienTra, String nguoiGiaoDich, String loaiGiaoDich, String ghiChuGiaoDich, String thoiGianGiaoDich, double laiSuat, String trangThai) {
>>>>>>> c24cf1a70906cb14cb882e393002a845aa71bd0c
        this.id = id;
        this.soTienVay = soTienVay;
        this.soTienTra = soTienTra;
        this.nguoiGiaoDich = nguoiGiaoDich;
        this.loaiGiaoDich = loaiGiaoDich;
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

<<<<<<< HEAD
    public float getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(float laiSuat) {
=======
    public double getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(double laiSuat) {
>>>>>>> c24cf1a70906cb14cb882e393002a845aa71bd0c
        this.laiSuat = laiSuat;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getLoaiGiaoDich() {
        return loaiGiaoDich;
    }

    public void setLoaiGiaoDich(String loaiGiaoDich) {
        this.loaiGiaoDich = loaiGiaoDich;
    }
}

package com.group1.LopCSDL;

public class ThongTinVayTra {

    public int id ;
    public long sotienvay ;
    public long sotiendatra ;
    public String hantra ;
    public String nguoigiaodich ;
    public String loaigiaodich ;
    public String ghichugiaodich ;
    public String thoigiangiaodich;
    public long laisuat ;
    public String trangthai ;

    public ThongTinVayTra() {
    }

    public ThongTinVayTra(int id, long sotienvay, long sotiendatra, String hantra, String nguoigiaodich, String loaigiaodich, String ghichugiaodich, String thoigiangiaodich, long laisuat, String trangthai) {
        this.id = id;
        this.sotienvay = sotienvay;
        this.sotiendatra = sotiendatra;
        this.hantra = hantra;
        this.nguoigiaodich = nguoigiaodich;
        this.loaigiaodich = loaigiaodich;
        this.ghichugiaodich = ghichugiaodich;
        this.thoigiangiaodich = thoigiangiaodich;
        this.laisuat = laisuat;
        this.trangthai = trangthai;
    }

    public ThongTinVayTra(long sotienvay, long sotiendatra, String hantra, String nguoigiaodich, String loaigiaodich, String ghichugiaodich, String thoigiangiaodich, long laisuat, String trangthai) {
        this.sotienvay = sotienvay;
        this.sotiendatra = sotiendatra;
        this.hantra = hantra;
        this.nguoigiaodich = nguoigiaodich;
        this.loaigiaodich = loaigiaodich;
        this.ghichugiaodich = ghichugiaodich;
        this.thoigiangiaodich = thoigiangiaodich;
        this.laisuat = laisuat;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getSotienvay() {
        return sotienvay;
    }

    public void setSotienvay(long sotienvay) {
        this.sotienvay = sotienvay;
    }

    public long getSotiendatra() {
        return sotiendatra;
    }

    public void setSotiendatra(long sotiendatra) {
        this.sotiendatra = sotiendatra;
    }

    public String getHantra() {
        return hantra;
    }

    public void setHantra(String hantra) {
        this.hantra = hantra;
    }

    public String getNguoigiaodich() {
        return nguoigiaodich;
    }

    public void setNguoigiaodich(String nguoigiaodich) {
        this.nguoigiaodich = nguoigiaodich;
    }

    public String getLoaigiaodich() {
        return loaigiaodich;
    }

    public void setLoaigiaodich(String loaigiaodich) {
        this.loaigiaodich = loaigiaodich;
    }

    public String getGhichugiaodich() {
        return ghichugiaodich;
    }

    public void setGhichugiaodich(String ghichugiaodich) {
        this.ghichugiaodich = ghichugiaodich;
    }

    public String getThoigiangiaodich() {
        return thoigiangiaodich;
    }

    public void setThoigiangiaodich(String thoigiangiaodich) {
        this.thoigiangiaodich = thoigiangiaodich;
    }

    public long getLaisuat() {
        return laisuat;
    }

    public void setLaisuat(long laisuat) {
        this.laisuat = laisuat;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
}

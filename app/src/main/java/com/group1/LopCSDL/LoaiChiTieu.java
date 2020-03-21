package com.group1.LopCSDL;

public class LoaiChiTieu {
    public String loaichitieu;
    public long sotien;
    public String end_buy_time;

    public LoaiChiTieu() {
    }

    public LoaiChiTieu(String loaichitieu, long sotien, String end_buy_time) {
        this.loaichitieu = loaichitieu;
        this.sotien = sotien;
        this.end_buy_time = end_buy_time;
    }

    public String getLoaichitieu() {
        return loaichitieu;
    }

    public void setLoaichitieu(String loaichitieu) {
        this.loaichitieu = loaichitieu;
    }

    public long getSotien() {
        return sotien;
    }

    public void setSotien(long sotien) {
        this.sotien = sotien;
    }

    public String getEnd_buy_time() {
        return end_buy_time;
    }

    public void setEnd_buy_time(String end_buy_time) {
        this.end_buy_time = end_buy_time;
    }
}

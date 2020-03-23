package com.group1.LopCSDL;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class LopCreat_Time {

    public static Calendar calendar;

    public static String ngayThang(){
        calendar  = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));

        int nam = calendar.get(Calendar.YEAR);
        int thang = calendar.get(Calendar.MONTH)+1 ;
        int ngay = calendar.get(Calendar.DATE);

        String ngayTN = String.format("%04d",nam) +"-"+ String.format("%02d",thang) +"-"+ String.format("%02d",ngay);
        return ngayTN;
    }

    public static String thangNamHienTai(){
        calendar  = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        int nam = calendar.get(Calendar.YEAR);
        int thang = calendar.get(Calendar.MONTH)+1 ;
        String tnHienTai = String.format("%04d",nam) +"-"+ String.format("%02d",thang);
        return tnHienTai;
    }

    public static String NamHienTai(){
        calendar  = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        int nam = calendar.get(Calendar.YEAR);

        String namHienTai = String.format("%04d",nam);
        return namHienTai;
    }

    public static void chang(){

    }

    public static String gioPhutGiay(){
        calendar  = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        int gio = calendar.getTime().getHours() ;
        int phut = calendar.getTime().getMinutes();
        int giay = calendar.getTime().getSeconds();
        String gioPG = String.format("%02d",gio) +":"+ String.format("%02d",phut) +":"+ String.format("%02d",giay);
        return gioPG;

    }

    public static String TongHopThoiGian(){

        return ngayThang() +" "+gioPhutGiay();
    }


}

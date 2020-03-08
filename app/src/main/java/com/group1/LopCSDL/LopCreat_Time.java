package com.group1.LopCSDL;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class LopCreat_Time {

    public static Calendar calendar;

    public static String ngayThang(){
        calendar  = Calendar.getInstance();
        int nam = calendar.get(Calendar.YEAR);
        int thang = calendar.get(Calendar.MONTH) +1;
        int ngay = calendar.get(Calendar.DATE);

        String ngayTN = nam +"/"+ thang +"/"+ngay;
        return ngayTN;
    }

    public static String gioPhutGiay(){
        //calendar.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        int gio = calendar.getTime().getHours() - 1;
        int phut = calendar.getTime().getMinutes();
        int giay = calendar.getTime().getSeconds();

        String gioPG = gio +":"+ phut +":"+giay;

        return gioPG;

    }

    public static String TongHopThoiGian(){

        return ngayThang() +"\n"+gioPhutGiay();
    }


}

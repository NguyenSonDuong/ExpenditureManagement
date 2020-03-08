package com.group1.LopCSDL;

import java.util.Calendar;
import java.util.Date;

public class LopCreat_Time {

    public static Calendar calendar;

    public static String ngayThang(){
        calendar  = Calendar.getInstance();
        int nam = calendar.get(Calendar.YEAR);
        int thang = calendar.get(Calendar.MONTH);
        int ngay = calendar.get(Calendar.DATE);
        Date gio = calendar.getTime();

        String dl = nam +"/"+ thang +"/"+ngay +"\n"+gio;
        return dl;
    }


}

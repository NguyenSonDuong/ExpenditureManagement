package com.group1.LopCSDL;

import java.util.ArrayList;

public class KeyDatabase {
    public static final String DATABASENAME = "database.db";
    public static final String TABLENAME_NGUOIDUNG = "NguoiDung";
    public static final String TABLENAME_CHITIEU = "ChiTieu";
    public static final String TABLENAME_VAY = "Vay";
    public static final String KEY_TIME_BACKUP = "time";
    public static final String BACKUP_FILE = "backup";
    public static final String LOGIN_INFOR_NAMEFILE = "login";
    public static final String LOGIN_OFFLINE_TOKEN = "token";
    public static final String LOGIN_OFFLINE_TIME = "logintime";
    public static final String LOGIN_OFFLINE_NICKNAME = "nickname";
    public static String DATABASENAME_INFOR = "";
    public static ArrayList<String> listLoaiGiaoDich(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Đồ tiêu dùng");
        list.add("Thực phẩm");
        list.add("Tiền dịch vụ");
        list.add("Tiền học");
        list.add("Tiền phụ phẩm");
        list.add("Tiền khác");
        return list;
    }
}

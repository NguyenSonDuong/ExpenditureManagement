package com.group1.expendituremanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.group1.LopCSDL.HoTroXuLyDataBase;
import com.group1.LopCSDL.KeyDatabase;
import com.group1.LopCSDL.XuLyDatabase;
import com.group1.server.XuLyServer;

public class DangNhap extends AppCompatActivity {
    EditText edit_nickname, edit_password;
    Button bt_dangnhap, bt_taotaikhoan;
    TextView bt_quenmatkhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        setWidth();
        setEvenDangNhap();
        String token = XuLyServer.getTokenOffline(this);
        if(!token.isEmpty() && token != null){
            KeyDatabase.DATABASENAME_INFOR = XuLyServer.getNicknameOffline(this)+".db";
            Intent intent = new Intent(DangNhap.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        setEvenTaoTaiKhoan();
    }

    public void setWidth(){
        edit_nickname = findViewById(R.id.edit_nickname);
        edit_password = findViewById(R.id.edit_password);
        bt_dangnhap = findViewById(R.id.bt_dangnhap);
        bt_quenmatkhau = findViewById(R.id.bt_quenmatkhau);
        bt_taotaikhoan = findViewById(R.id.bt_taotaikhoan);
    }

    public void setEvenDangNhap(){
        bt_dangnhap.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String name = edit_nickname.getText().toString();
                String pass = edit_password.getText().toString();
                if(name.isEmpty() || pass.isEmpty()){
                    Toast.makeText(DangNhap.this, "Vui lòng nhập đầy đủ dữ liện", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(HoTroXuLyDataBase.loginCheck(DangNhap.this,name,pass)){
                    XuLyServer.LoginReponsiveClass loginReponsiveClass = XuLyServer.getReponsiveLogin(DangNhap.this,name,pass);
                    if(loginReponsiveClass == null){
                        Toast.makeText(DangNhap.this, "Đăng nhập online thất bại", Toast.LENGTH_SHORT).show();
                    }
                    XuLyServer.setDataToFile(DangNhap.this,KeyDatabase.LOGIN_INFOR_NAMEFILE,KeyDatabase.LOGIN_OFFLINE_TOKEN,loginReponsiveClass.access_token);
                    XuLyServer.setDataToFile(DangNhap.this,KeyDatabase.LOGIN_INFOR_NAMEFILE,KeyDatabase.LOGIN_OFFLINE_NICKNAME,loginReponsiveClass.nickname);
                    XuLyServer.setDataToFile(DangNhap.this,KeyDatabase.LOGIN_INFOR_NAMEFILE,KeyDatabase.LOGIN_OFFLINE_TIME,loginReponsiveClass.create_time);
                    KeyDatabase.DATABASENAME_INFOR = loginReponsiveClass.nickname+".db";
                    Intent intent = new Intent(DangNhap.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    XuLyServer.LoginReponsiveClass loginReponsiveClass = XuLyServer.getReponsiveLogin(DangNhap.this,name,pass);
                    if(loginReponsiveClass == null){
                        Toast.makeText(DangNhap.this, "Đăng nhập online thất bại", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    XuLyDatabase xuLyDatabase = new XuLyDatabase(DangNhap.this, KeyDatabase.DATABASENAME,null, 1);
                    boolean re = HoTroXuLyDataBase.registerUserSQLLite(xuLyDatabase,name,pass,"",0,"");
                    if(re){
                        Toast.makeText(DangNhap.this, "Đã đăng ký tài khoản online vào nội bộ", Toast.LENGTH_SHORT).show();
                        XuLyServer.setDataToFile(DangNhap.this,KeyDatabase.LOGIN_INFOR_NAMEFILE,KeyDatabase.LOGIN_OFFLINE_TOKEN,loginReponsiveClass.access_token);
                        XuLyServer.setDataToFile(DangNhap.this,KeyDatabase.LOGIN_INFOR_NAMEFILE,KeyDatabase.LOGIN_OFFLINE_NICKNAME,loginReponsiveClass.nickname);
                        XuLyServer.setDataToFile(DangNhap.this,KeyDatabase.LOGIN_INFOR_NAMEFILE,KeyDatabase.LOGIN_OFFLINE_TIME,loginReponsiveClass.create_time);
                        KeyDatabase.DATABASENAME_INFOR = loginReponsiveClass.nickname+".db";
                        SyncData.Synch(DangNhap.this);
                        Intent intent = new Intent(DangNhap.this, MainActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(DangNhap.this, "Đăng ký tài khoản thất bại trên nội bộ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void showDialogOnline(){
        Dialog dialog = new Dialog(DangNhap.this);
        dialog.setTitle("Đăng nhập");
        dialog.show();
    }

    public void setEvenTaoTaiKhoan(){
        bt_taotaikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhap.this, Dang_Ky.class);
                startActivity(intent);
            }
        });
    }
}

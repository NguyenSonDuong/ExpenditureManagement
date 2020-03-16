package com.group1.expendituremanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.group1.LopCSDL.HoTroXuLyDataBase;
import com.group1.LopCSDL.KeyDatabase;
import com.group1.LopCSDL.XuLyDatabase;

public class DangNhap extends AppCompatActivity {
    EditText edit_nickname, edit_password;
    Button bt_dangnhap, bt_quenmatkhau, bt_taotaikhoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        setWidth();
        setEvenDangNhap();
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
                showDialogOnline();
                if(HoTroXuLyDataBase.loginCheck(DangNhap.this,name,pass)){
                    Intent intent = new Intent(DangNhap.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(DangNhap.this, "Tài khoản và mật khẩu không đúng", Toast.LENGTH_SHORT).show();
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

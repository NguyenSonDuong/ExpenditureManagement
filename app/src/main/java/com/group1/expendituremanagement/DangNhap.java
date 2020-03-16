package com.group1.expendituremanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                XuLyDatabase xuLyDatabase = new XuLyDatabase(DangNhap.this, KeyDatabase.DATABASENAME,null, 1);
                Cursor cursor = xuLyDatabase.traVeKQ("SELECT * FROM "+KeyDatabase.TABLENAME_NGUOIDUNG+" WHERE nickName = '"+name+"' AND PassWord = '"+pass+"'");
                if(cursor.getCount() != 1){
                    Toast.makeText(DangNhap.this,"Email hoặc mật khẩu không chính xác", Toast.LENGTH_LONG).show();
                }else {
                    Intent intent = new Intent(DangNhap.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
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

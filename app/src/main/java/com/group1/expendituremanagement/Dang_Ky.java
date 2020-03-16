package com.group1.expendituremanagement;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.group1.LopCSDL.HoTroXuLyDataBase;
import com.group1.LopCSDL.KeyDatabase;
import com.group1.LopCSDL.XuLyDatabase;
import com.group1.server.XuLyServer;

public class Dang_Ky extends AppCompatActivity {

    EditText edtnhapTenTK,edtPass,edtMK,edtdEmail;
    RadioButton rdgNam,rdgNu;
    CheckBox checkeddk;
    Button btnDK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang__ky);
        edtdEmail = (EditText) findViewById(R.id.edtdEmail);
        edtnhapTenTK = (EditText) findViewById(R.id.edtnhapTenTK);
        edtMK = (EditText) findViewById(R.id.edtPass);
        rdgNam = (RadioButton) findViewById(R.id.rdgNam);
        rdgNu = (RadioButton) findViewById(R.id.rdgNu);
        btnDK = (Button) findViewById(R.id.btnDK);
        checkeddk = (CheckBox) findViewById(R.id.checkeddk);




        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nickname = edtnhapTenTK.getText().toString();
                String password  = edtMK.getText().toString();
                String email = edtdEmail.getText().toString();

                int sex = 1;
                if(rdgNam.isChecked()){
                    sex=2;
                }
                XuLyDatabase xuLyDatabase = new XuLyDatabase(Dang_Ky.this, KeyDatabase.DATABASENAME,null,1);
                boolean dangky = HoTroXuLyDataBase.registerUserSQLLite(xuLyDatabase,nickname,password,email,sex,"");
                if(dangky){
                    Toast.makeText(Dang_Ky.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(Dang_Ky.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                }
                //XuLyServer.RegisterReponsiveClass registerReponsiveClass = XuLyServer.getReponsiveRegister(Dang_Ky.this,edtnhapTenTK.getText().toString(),edtMK.getText().toString(),edtdEmail.getText().toString(),a);
//                if(registerReponsiveClass == null){
//                    //Toast.makeText(getApplicationContext(), "Lỗi", Toast.LENGTH_SHORT).show();
//                }else {
//                    //Toast.makeText(getApplicationContext(), "Nickname: "+registerReponsiveClass.nickname, Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }
}

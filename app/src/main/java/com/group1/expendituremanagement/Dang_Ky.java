package com.group1.expendituremanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

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


        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = 1;
                if(rdgNam.isChecked()){
                    a=2;
                }
                XuLyServer.RegisterReponsiveClass registerReponsiveClass = XuLyServer.getReponsiveRegister(Dang_Ky.this,edtnhapTenTK.getText().toString(),edtMK.getText().toString(),edtdEmail.getText().toString(),a);
                if(registerReponsiveClass == null){
                    Toast.makeText(getApplicationContext(), "Lỗi", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Nickname: "+registerReponsiveClass.nickname, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

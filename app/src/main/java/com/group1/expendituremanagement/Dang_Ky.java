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
        init();
        setEvent();

    }

    public void init(){
        edtdEmail = (EditText) findViewById(R.id.edtdEmail);
        edtnhapTenTK = (EditText) findViewById(R.id.edtnhapTenTK);
        edtMK = (EditText) findViewById(R.id.edtPass);
        rdgNam = (RadioButton) findViewById(R.id.rdgNam);
        edtPass = (EditText) findViewById(R.id.edtPass);
        rdgNu = (RadioButton) findViewById(R.id.rdgNu);
        btnDK = (Button) findViewById(R.id.btnDK);
        checkeddk = (CheckBox) findViewById(R.id.checkeddk);
    }
    public void setEvent(){
        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nickname = edtnhapTenTK.getText().toString();
                String password  = edtPass.getText().toString();
                String email = edtdEmail.getText().toString();
                String rePass = edtMK.getText().toString();
                if(!checkeddk.isChecked()){
                    Toast.makeText(Dang_Ky.this, "Vui lòng đồng ý với điều khoản để tiếp tục đăng ký", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!password.equals(rePass)){
                    Toast.makeText(Dang_Ky.this, "Mật khẩu không trùng khớp nhau", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(nickname.isEmpty() || password.isEmpty() || email.isEmpty()){
                    Toast.makeText(Dang_Ky.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }

                int sex = 1;
                if(rdgNam.isChecked()){
                    sex=2;
                }
                XuLyDatabase xuLyDatabase = new XuLyDatabase(Dang_Ky.this, KeyDatabase.DATABASENAME,null,1);
                boolean dangky = HoTroXuLyDataBase.registerUserSQLLite(xuLyDatabase,nickname,password,email,sex,"");
                if(dangky){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Dang_Ky.this);
                    builder.setTitle("Thông báo đăng ký online");
                    builder.setMessage("Bạn đã đăng ký thành công. Bạn có muốn chúng tôi đăng ký tài khoản online cho bạn để bạn có thể đồng bộ dữ liệu lên máy chủ của chứng tôi không");
                    builder.setNegativeButton("Đồng ý", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            XuLyServer.RegisterReponsiveClass online = registerOnline();
                            if(online != null){
                                if(online.table_chi_tieu.equals("Thất bại") || online.table_vay.equals("Thất bại")){
                                    Toast.makeText(Dang_Ky.this, "Đăng ký online không thành công", Toast.LENGTH_SHORT).show();
                                }
                                Toast.makeText(Dang_Ky.this, "Đăng ký online thành công", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(Dang_Ky.this, "Đăng ký online không thành công", Toast.LENGTH_SHORT).show();
                            }
                            Dang_Ky.this.finish();
                        }
                    });
                    builder.setPositiveButton("Không đồng ý", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Dang_Ky.this.finish();
                        }
                    });
                    builder.show();
                }else {
                    Toast.makeText(Dang_Ky.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public XuLyServer.RegisterReponsiveClass registerOnline(){
        int sex = 1;
        if(rdgNam.isChecked()){
            sex=2;
        }
        XuLyServer.RegisterReponsiveClass registerReponsiveClass = XuLyServer.getReponsiveRegister(Dang_Ky.this,edtnhapTenTK.getText().toString(),edtMK.getText().toString(),edtdEmail.getText().toString(),sex);
        if(registerReponsiveClass == null){
            return null;
        }else {
            return registerReponsiveClass;
        }
    }
}

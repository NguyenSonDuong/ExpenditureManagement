package com.group1.expendituremanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.group1.LopCSDL.HoTroXuLyDataBase;
import com.group1.LopCSDL.KeyDatabase;
import com.group1.LopCSDL.LopCreat_Time;
import com.group1.LopCSDL.ThongTinChiTieu;
import com.group1.LopCSDL.ThongTinVayTra;
import com.group1.LopCSDL.XuLyDatabase;
import com.group1.server.XuLyServer;

import java.util.ArrayList;

public class BackupData extends AppCompatActivity {

    TextView tvTime;
    Button btnBackup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backup_data);
        init();
        setEvent();
    }

    private void setEvent() {
        btnBackup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyDatabase xuLyDatabase = new XuLyDatabase(BackupData.this, KeyDatabase.DATABASENAME_INFOR,null,1);
                ArrayList<ThongTinVayTra> listVayTra = HoTroXuLyDataBase.layDLVayTra(xuLyDatabase);
                ArrayList<ThongTinChiTieu> listChiTieu = HoTroXuLyDataBase.layDLChiTieu(xuLyDatabase);
                Object objChiTieu = XuLyServer.backupChiTieu(BackupData.this,XuLyServer.convertChiTieuToJson(XuLyServer.getTokenOffline(BackupData.this),listChiTieu));
                Object obj = XuLyServer.backupVay(BackupData.this,XuLyServer.convertVayTraToJson(XuLyServer.getTokenOffline(BackupData.this),listVayTra));
                if(objChiTieu == null || obj == null){
                    Toast.makeText(BackupData.this, "Lỗi kết nối server", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(obj instanceof XuLyServer.ReponsiveSuccessfull){
                    Toast.makeText(BackupData.this, "Đã thêm dữ liệu chi tiêu thành công", Toast.LENGTH_SHORT).show();
                    if(objChiTieu instanceof XuLyServer.ReponsiveSuccessfull){
                        Toast.makeText(BackupData.this, "Đã thêm dữ liệu vay thành công", Toast.LENGTH_SHORT).show();
                    }else {
                        XuLyServer.ReponsiveFalse.Rootobject reponsiveFalse = (XuLyServer.ReponsiveFalse.Rootobject) obj;
                        Toast.makeText(BackupData.this, "Dữ liệu đã được backup trước đó: "+reponsiveFalse.data.length, Toast.LENGTH_SHORT).show();
                    }
                    XuLyServer.setDataToFile(BackupData.this,KeyDatabase.BACKUP_FILE,KeyDatabase.KEY_TIME_BACKUP, LopCreat_Time.TongHopThoiGian());
                }else if(obj instanceof XuLyServer.ReponsiveFalse.Rootobject){
                    XuLyServer.ReponsiveFalse.Rootobject reponsiveFalse = (XuLyServer.ReponsiveFalse.Rootobject) obj;
                    Toast.makeText(BackupData.this, "Dữ liệu đã được backup trước đó: "+reponsiveFalse.data.length, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        tvTime = (TextView) findViewById(R.id.tvTime);
        btnBackup = (Button) findViewById(R.id.btnBackup);
        tvTime.setText(XuLyServer.getTimeBackup(this));
    }
}

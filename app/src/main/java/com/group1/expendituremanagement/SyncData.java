package com.group1.expendituremanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.group1.LopCSDL.HoTroXuLyDataBase;
import com.group1.LopCSDL.KeyDatabase;
import com.group1.LopCSDL.ThongTinChiTieu;
import com.group1.LopCSDL.ThongTinVayTra;
import com.group1.LopCSDL.XuLyDatabase;
import com.group1.server.XuLyServer;

import java.util.ArrayList;

public class SyncData extends AppCompatActivity {

    TextView tvTime;
    Button btnSynch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync_data);
        init();
        setEvent();
    }

    private void setEvent() {
        btnSynch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<ThongTinChiTieu> chiTieuArrayList = XuLyServer.synchChiTieu(SyncData.this,XuLyServer.getTokenOffline(SyncData.this));
                ArrayList<ThongTinVayTra> vayTraArrayList = XuLyServer.synchVay(SyncData.this,XuLyServer.getTokenOffline(SyncData.this));
                XuLyDatabase xuLyDatabase = new XuLyDatabase(SyncData.this, KeyDatabase.DATABASENAME_INFOR,null,1);
                if(chiTieuArrayList.size() >1){
                    int dem =0;
                    int error =0;
                    for(ThongTinChiTieu item : chiTieuArrayList){
                        boolean te = HoTroXuLyDataBase.addChiTieu(xuLyDatabase, item);
                        if(te){
                            dem++;
                        }else {
                            error++;
                        }
                    }
                    Toast.makeText(SyncData.this, "Đã đồng bộ: "+dem+"\nĐã đồng bộ lỗi: "+error, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(SyncData.this, "Không có dữ liệu chi tiêu để đồng bộ", Toast.LENGTH_SHORT).show();
                }
                if(vayTraArrayList.size() >1){
                    int dem =0;
                    int error =0;
                    for(ThongTinVayTra item : vayTraArrayList){
                        boolean te = HoTroXuLyDataBase.addVayTra(xuLyDatabase, item);
                        if(te){
                            dem++;
                        }else {
                            error++;
                        }
                    }
                    Toast.makeText(SyncData.this, "Đã đồng bộ: "+dem+"\nĐã đồng bộ lỗi: "+error, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        tvTime = (TextView) findViewById(R.id.tvTime);
        btnSynch = (Button) findViewById(R.id.btnSynch);
    }


}

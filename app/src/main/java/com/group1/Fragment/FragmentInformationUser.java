package com.group1.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.group1.LopCSDL.HoTroXuLyDataBase;
import com.group1.LopCSDL.KeyDatabase;
import com.group1.LopCSDL.ThongTinNguoiDung;
import com.group1.LopCSDL.XuLyDatabase;
import com.group1.expendituremanagement.BackupData;
import com.group1.expendituremanagement.R;
import com.group1.expendituremanagement.SyncData;
import com.group1.server.XuLyServer;

import java.security.Key;

public class FragmentInformationUser extends Fragment {
    Context context;
    TextView tvNickName,tvEmail,tvGioiTinh,tvThoiGian;
    Button btBackupNgDung,btDongBoNgDung;
    public FragmentInformationUser(Context context) {
        this.context = context;
    }

    public FragmentInformationUser(int contentLayoutId, Context context) {
        super(contentLayoutId);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_thong_tin_nguoi_dung,container,false);
        init(view);
        setInfor();
        setEvent();
        return view;
    }

    private void setInfor() {
        XuLyDatabase xuLyDatabase = new XuLyDatabase(context, KeyDatabase.DATABASENAME,null,1);
        ThongTinNguoiDung thongTinNguoiDung = HoTroXuLyDataBase.getInforUser(xuLyDatabase, XuLyServer.getNicknameOffline(context));
        if(thongTinNguoiDung==null){
            Toast.makeText(context, "lỗi truy xuất dữ liệu người dùng", Toast.LENGTH_SHORT).show();
        }
        tvNickName.setText(thongTinNguoiDung.getNickName());
        tvEmail.setText(thongTinNguoiDung.getEmail());
        String sex="Nam";
        if(thongTinNguoiDung.getGioiTinh()<=0){
            sex = "Nữ";
        }
        tvGioiTinh.setText(sex);
        tvThoiGian.setText(thongTinNguoiDung.getCreate_time());
    }

    public void setEvent(){
        btBackupNgDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BackupData.class);
                context.startActivity(intent);
            }
        });
        btDongBoNgDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SyncData.class);
                context.startActivity(intent);
            }
        });
    }

    public void init(View view){
        tvNickName = (TextView) view.findViewById(R.id.tvNickName);
        tvEmail = (TextView) view.findViewById(R.id.tvEmail);
        tvGioiTinh = (TextView) view.findViewById(R.id.tvGioiTinh);
        tvThoiGian = (TextView) view.findViewById(R.id.tvThoiGian);
        btBackupNgDung = view.findViewById(R.id.btBackupNgDung);
        btDongBoNgDung =  view.findViewById(R.id.btDongBoNgDung);

    }
}

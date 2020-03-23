package com.group1.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.group1.LopCSDL.HoTroXuLyDataBase;
import com.group1.LopCSDL.KeyDatabase;
import com.group1.LopCSDL.LopCreat_Time;
import com.group1.LopCSDL.XuLyDatabase;
import com.group1.expendituremanagement.R;
import com.group1.server.XuLyServer;

public class Fragment_Thong_Ke_Vay_Tra extends Fragment {
    Context context;
    XuLyDatabase xuLyDatabase;
    TextView tvSoTienVayNgay, tvSoTienVayThang, tvSoTienVayNam, tvSoTienChoVayNgay, tvSoTienChoVayThang, tvSoTienChoVayNam;
    long sumNgayVay, sumThangVay, sumNamVay;
    long sumNgayChoVay, sumThangChoVay, sumNamChoVay;

    public Fragment_Thong_Ke_Vay_Tra(Context context) {
        this.context = context;
    }

    public Fragment_Thong_Ke_Vay_Tra(int contentLayoutId, Context context) {
        super(contentLayoutId);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(context).inflate(R.layout.activity_thong_ke_vay_tra, container, false);

        init(view);
        readDL();
        return view;
    }

    public void init(View view){


        tvSoTienVayNgay = view.findViewById(R.id.tvSoTienVayNgay);
        tvSoTienVayThang = view.findViewById(R.id.tvSoTienVayThang);
        tvSoTienVayNam = view.findViewById(R.id.tvSoTienVayNam);
        tvSoTienChoVayNgay = view.findViewById(R.id.tvSoTienChoVayNgay);
        tvSoTienChoVayThang = view.findViewById(R.id.tvSoTienChoVayThang);
        tvSoTienChoVayNam = view.findViewById(R.id.tvSoTienChoVayNam);
    }

    public void readDL(){
        xuLyDatabase = new XuLyDatabase(context, KeyDatabase.DATABASENAME_INFOR, null, 1);

        sumNgayVay = HoTroXuLyDataBase.getVayTheoNgay(xuLyDatabase, LopCreat_Time.ngayThang());
        sumThangVay = HoTroXuLyDataBase.getVayTheoThang(xuLyDatabase, LopCreat_Time.thangNamHienTai());
        sumNamVay = HoTroXuLyDataBase.getVayTheoNam(xuLyDatabase, LopCreat_Time.NamHienTai());
        sumNgayChoVay = HoTroXuLyDataBase.getTraTheoNgay(xuLyDatabase, LopCreat_Time.ngayThang());
        sumThangChoVay = HoTroXuLyDataBase.getTraTheoThang(xuLyDatabase, LopCreat_Time.thangNamHienTai());
        sumNamChoVay = HoTroXuLyDataBase.getTraTheoNam(xuLyDatabase, LopCreat_Time.NamHienTai());

        tvSoTienVayNgay.setText(XuLyServer.formatMoney(sumNgayVay)+" đ");
        tvSoTienVayThang.setText(XuLyServer.formatMoney(sumThangVay)+" đ");
        tvSoTienVayNam.setText(XuLyServer.formatMoney(sumNamVay)+" đ");

        tvSoTienChoVayNgay.setText(XuLyServer.formatMoney(sumNgayChoVay)+" đ");
        tvSoTienChoVayThang.setText(XuLyServer.formatMoney(sumThangChoVay)+" đ");
        tvSoTienChoVayNam.setText(XuLyServer.formatMoney(sumNamChoVay)+" đ");
    }
}

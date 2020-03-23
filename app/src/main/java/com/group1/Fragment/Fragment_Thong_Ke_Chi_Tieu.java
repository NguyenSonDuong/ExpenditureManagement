package com.group1.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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

public class Fragment_Thong_Ke_Chi_Tieu extends Fragment {

    Context context;
    long sumChiTieuNgay, sumChiTieuThang, sumChiTieuNam;
    XuLyDatabase xuLyDatabase;
    TextView tvSoTienNgay, tvSoTienThang, tvSoTienNam;

    public Fragment_Thong_Ke_Chi_Tieu(Context context) {
        this.context = context;
    }

    public Fragment_Thong_Ke_Chi_Tieu(int contentLayoutId, Context context) {
        super(contentLayoutId);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_thong__ke__chi__tieu, container, false);

        init(view);
        xuLy();

        return view;
    }

    public void init(View view){
        tvSoTienNgay = (TextView) view.findViewById(R.id.tvSoTienNgay);
        tvSoTienThang = (TextView) view.findViewById(R.id.tvSoTienThang);
        tvSoTienNam = (TextView) view.findViewById(R.id.tvSoTienNam);
    }

    public void xuLy(){
        xuLyDatabase = new XuLyDatabase(context, KeyDatabase.DATABASENAME_INFOR, null, 1);

        sumChiTieuNgay = HoTroXuLyDataBase.getChiTieuTheoNgay(xuLyDatabase, LopCreat_Time.ngayThang());
        sumChiTieuThang = HoTroXuLyDataBase.getChiTieuTheoThang(xuLyDatabase, LopCreat_Time.thangNamHienTai());
        sumChiTieuNam = HoTroXuLyDataBase.getChiTieuTheoNam(xuLyDatabase, LopCreat_Time.NamHienTai());

        tvSoTienNgay.setText(XuLyServer.formatMoney(sumChiTieuNgay));
        tvSoTienThang.setText(XuLyServer.formatMoney(sumChiTieuThang));
        tvSoTienNam.setText(XuLyServer.formatMoney(sumChiTieuNam));
    }


}

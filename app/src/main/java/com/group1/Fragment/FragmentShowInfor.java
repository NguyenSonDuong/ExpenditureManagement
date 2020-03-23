package com.group1.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.group1.LopCSDL.HoTroXuLyDataBase;
import com.group1.LopCSDL.KeyDatabase;
import com.group1.LopCSDL.LoaiChiTieu;
import com.group1.LopCSDL.LopCreat_Time;
import com.group1.LopCSDL.XuLyDatabase;
import com.group1.adapter.LoaiChiTieuAdapter;
import com.group1.expendituremanagement.R;
import com.group1.server.XuLyServer;

import java.util.ArrayList;

public class FragmentShowInfor extends Fragment {

    Context context;
    ListView listView;
    TextView tvNowTime,tvCountMoney;
    public FragmentShowInfor(Context context) {
        this.context = context;
    }

    public FragmentShowInfor(int contentLayoutId, Context context) {
        super(contentLayoutId);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_infor,container,false);
        init(view);
        XuLyDatabase xuLyDatabase = new XuLyDatabase(context, KeyDatabase.DATABASENAME_INFOR,null,1);
        ArrayList<LoaiChiTieu> list = HoTroXuLyDataBase.getThongLoaiChiTieu(xuLyDatabase,KeyDatabase.listLoaiGiaoDich(), LopCreat_Time.ngayThang());
        tvNowTime.setText(LopCreat_Time.ngayThang());
        long money =HoTroXuLyDataBase.getChiTieuTheoNgay(new XuLyDatabase(context,KeyDatabase.DATABASENAME_INFOR,null,1),LopCreat_Time.ngayThang());
        tvCountMoney.setText(XuLyServer.formatMoney(money) +" đ");
        LoaiChiTieuAdapter loaiChiTieuAdapter = new LoaiChiTieuAdapter(list,context);
        listView.setAdapter(loaiChiTieuAdapter);
        return view;
    }

    public void init(View view){
        listView = view.findViewById(R.id.lvDS);
        tvCountMoney = (TextView) view.findViewById(R.id.tvCountMoney);
        tvNowTime = (TextView) view.findViewById(R.id.tvNowTime);
    }
}

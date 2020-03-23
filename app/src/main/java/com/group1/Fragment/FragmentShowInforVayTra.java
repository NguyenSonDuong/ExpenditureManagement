package com.group1.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.group1.LopCSDL.HoTroXuLyDataBase;
import com.group1.LopCSDL.KeyDatabase;
import com.group1.LopCSDL.LopCreat_Time;
import com.group1.LopCSDL.ThongTinVayTra;
import com.group1.LopCSDL.XuLyDatabase;
import com.group1.expendituremanagement.R;
import com.group1.server.XuLyServer;

import java.util.ArrayList;

public class FragmentShowInforVayTra extends Fragment {

    Context context;
    ListView lvDS;
    TextView tvSoTienDV,tvGhiChuDV,tvSoTienCV,tvGhiChuCV;
    ImageView ivShowVayTraCV,ivShowVayTraDV;
    ArrayList<ThongTinVayTra> thongTinVayTras;
    ArrayList<String> data;
    ArrayAdapter<String> arrayAdapter;
    public FragmentShowInforVayTra(Context context) {
        this.context = context;
    }

    public FragmentShowInforVayTra(int contentLayoutId, Context context) {
        super(contentLayoutId);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(context).inflate(R.layout.show_vay_infor,null,false);
        init(view);
        final XuLyDatabase xuLyDatabase = new XuLyDatabase(context, KeyDatabase.DATABASENAME_INFOR,null,1);
        ivShowVayTraCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.clear();
                thongTinVayTras = HoTroXuLyDataBase.layDLVayTraLoai(xuLyDatabase,"Cho vay",LopCreat_Time.ngayThang());
                for(ThongTinVayTra item : thongTinVayTras){
                    data.add(item.getNguoigiaodich()+" : " +item.sotienvay);
                }
                arrayAdapter.notifyDataSetChanged();

            }
        });
        ivShowVayTraDV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.clear();
                thongTinVayTras = HoTroXuLyDataBase.layDLVayTraLoai(xuLyDatabase,"Đi vay",LopCreat_Time.ngayThang());
                for(ThongTinVayTra item : thongTinVayTras){
                    data.add(item.getNguoigiaodich()+" : " +item.sotienvay);
                }
                arrayAdapter.notifyDataSetChanged();
            }
        });

        tvSoTienDV.setText(XuLyServer.formatMoney(HoTroXuLyDataBase.getVayTheoNgay(xuLyDatabase, LopCreat_Time.ngayThang())));
        tvSoTienCV.setText(XuLyServer.formatMoney(HoTroXuLyDataBase.getTraTheoNgay(xuLyDatabase, LopCreat_Time.ngayThang())));
        return view;
    }

    private void init(View view) {
        tvSoTienDV = (TextView) view.findViewById(R.id.tvSoTienDV);
        tvSoTienCV = (TextView) view.findViewById(R.id.tvSoTienCV);
        ivShowVayTraCV = (ImageView) view.findViewById(R.id.ivShowVayTraCV);
        ivShowVayTraDV = (ImageView) view.findViewById(R.id.ivShowVayTraDV);
        thongTinVayTras = new ArrayList<>();
        data = new ArrayList<>();
        lvDS = view.findViewById(R.id.lvDS);
        arrayAdapter = new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,data);
        lvDS.setAdapter(arrayAdapter);

    }
}

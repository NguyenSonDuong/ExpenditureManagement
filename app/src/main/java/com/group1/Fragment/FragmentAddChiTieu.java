package com.group1.Fragment;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.group1.LopCSDL.HoTroXuLyDataBase;
import com.group1.LopCSDL.KeyDatabase;
import com.group1.LopCSDL.LopCreat_Time;
import com.group1.LopCSDL.ThongTinChiTieu;
import com.group1.LopCSDL.XuLyDatabase;
import com.group1.expendituremanagement.R;

import java.util.ArrayList;

public class FragmentAddChiTieu  extends Fragment {

    Context context;
    EditText edit_soluong,edit_tientieu,edit_thoigian,edit_diadiem,edit_ghichu;
    Button bt_themtt;
    Spinner snipLoaiGD;

    public FragmentAddChiTieu(Context context) {
        this.context = context;
    }

    public FragmentAddChiTieu(int contentLayoutId, Context context) {
        super(contentLayoutId);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(context).inflate(R.layout.add_chitieu,container,false);
        init(view);
        addSpiner();
        setEvent();
        return view;
    }

    private void setEvent() {
        bt_themtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "OK: "+snipLoaiGD.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                XuLyDatabase xuLyDatabase = new XuLyDatabase(context, KeyDatabase.DATABASENAME_INFOR,null,1);
                ThongTinChiTieu thongTinChiTieu = new ThongTinChiTieu();
                thongTinChiTieu.setSoTien(Double.parseDouble(edit_tientieu.getText().toString()));
                thongTinChiTieu.setLoaiGiaoDich(snipLoaiGD.getSelectedItem().toString());
                thongTinChiTieu.setDiaDiem(edit_diadiem.getText().toString());
                thongTinChiTieu.setThoiGianGiaoDich(edit_thoigian.getText().toString());
                thongTinChiTieu.setGhiChuGiaoDich(edit_ghichu.getText().toString());
                thongTinChiTieu.setSoLuong(Integer.parseInt(edit_soluong.getText().toString()));
                boolean re = HoTroXuLyDataBase.addChiTieu(xuLyDatabase,thongTinChiTieu);
                if(re){
                    Toast.makeText(context, "Thêm dữ liệu thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "Thêm dữ liệu không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void addSpiner(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Đồ tiêu dùng");
        list.add("Thực phẩm");
        list.add("Tiền dịch vụ");
        list.add("Tiền học");
        list.add("Tiền phụ phẩm");
        list.add("Tiền khác");
        snipLoaiGD.setAdapter(new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,list));
    }
    private void init(View view) {
        edit_tientieu = (EditText) view.findViewById(R.id.edit_tientieu);
        edit_diadiem = (EditText) view.findViewById(R.id.edit_diadiem);
        edit_soluong = (EditText) view.findViewById(R.id.edit_soluong);
        edit_thoigian = (EditText) view.findViewById(R.id.edit_thoigian);
        edit_ghichu = (EditText) view.findViewById(R.id.edit_ghichu);
        bt_themtt = (Button) view.findViewById(R.id.bt_themtt);
        snipLoaiGD = (Spinner) view.findViewById(R.id.snipLoaiGD);
        edit_thoigian.setText(LopCreat_Time.TongHopThoiGian());
    }


}

package com.group1.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.group1.LopCSDL.HoTroXuLyDataBase;
import com.group1.LopCSDL.KeyDatabase;
import com.group1.LopCSDL.LopCreat_Time;
import com.group1.LopCSDL.ThongTinVayTra;
import com.group1.LopCSDL.XuLyDatabase;
import com.group1.expendituremanagement.R;

public class FragmentAddVay extends Fragment {
    Context context;

    Button btnAdd;
    EditText edtSTV,STT,edtNGD,GGD,edtTGD,edtLS,edtThoiGianTra;
    RadioButton rdDiVay,rdChoVay;
    CheckBox cktT;

    public FragmentAddVay(Context context) {
        this.context = context;
    }

    public FragmentAddVay(int contentLayoutId, Context context) {
        super(contentLayoutId);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(context).inflate(R.layout.add_vay,container,false);
        init(view);
        setEvent();
        return view;
    }


    private void init(View view) {
        edtSTV = (EditText) view.findViewById(R.id.edtSTV);
        STT = (EditText) view.findViewById(R.id.STT);
        edtNGD = (EditText) view.findViewById(R.id.edtNGD);
        GGD = (EditText) view.findViewById(R.id.GGD);
        edtTGD = (EditText) view.findViewById(R.id.edtTGD);
        edtLS = (EditText) view.findViewById(R.id.edtLS);
        edtThoiGianTra = (EditText) view.findViewById(R.id.edtThoiGianTra);
        rdDiVay = (RadioButton) view.findViewById(R.id.rdDiVay);
        rdChoVay = (RadioButton) view.findViewById(R.id.rdChoVay);
        cktT = (CheckBox) view.findViewById(R.id.ckDTX);
        btnAdd = (Button) view.findViewById(R.id.btnAdd);
        edtThoiGianTra.setText(LopCreat_Time.TongHopThoiGian());
        edtTGD.setText(LopCreat_Time.TongHopThoiGian());
    }
    private void setEvent(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyDatabase xuLyDatabase = new XuLyDatabase(context, KeyDatabase.DATABASENAME_INFOR,null,1);
                ThongTinVayTra thongTinVayTra = new ThongTinVayTra();
                if(edtTGD.getText().toString().isEmpty() || STT.getText().toString().isEmpty() || edtNGD.getText().toString().isEmpty() ||
                edtSTV.getText().toString().isEmpty() || GGD.getText().toString().isEmpty() || edtLS.getText().toString().isEmpty()){
                    Toast.makeText(context, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                };
                thongTinVayTra.setSotienvay(Integer.parseInt(edtSTV.getText().toString()));
                thongTinVayTra.setSotiendatra(Integer.parseInt(STT.getText().toString()));
                thongTinVayTra.setNguoigiaodich(edtNGD.getText().toString());
                thongTinVayTra.setGhichugiaodich(GGD.getText().toString());
                thongTinVayTra.setThoigiangiaodich(edtTGD.getText().toString());
                thongTinVayTra.setHantra(edtThoiGianTra.getText().toString());
                if(rdChoVay.isChecked()){
                    thongTinVayTra.setLoaigiaodich(rdChoVay.getText().toString());
                }
                if(rdDiVay.isChecked()){
                    thongTinVayTra.setLoaigiaodich(rdDiVay.getText().toString());
                }
                thongTinVayTra.setLaisuat(Integer.parseInt(edtLS.getText().toString()));
                thongTinVayTra.setTrangthai(cktT.isChecked()+"");
                boolean bo = HoTroXuLyDataBase.addVayTra(xuLyDatabase,thongTinVayTra);
                if(bo){
                    Toast.makeText(context, "Thêm dữ liệu thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "Thêm dữu liệu không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}

package com.group1.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.group1.LopCSDL.ThongTinChiTieu;
import com.group1.adapter.ChiTieuAdapter;
import com.group1.expendituremanagement.R;

import java.util.ArrayList;

public class ChiTieuDialog extends Dialog {

    Context context;
    ListView lvDS;
    ImageView imgCancel;
    ArrayList<ThongTinChiTieu> list;
    ChiTieuAdapter chiTieuAdapter;

    public ChiTieuDialog(@NonNull Context context, Context context1, ArrayList<ThongTinChiTieu> list) {
        super(context);
        this.context = context1;
        this.list = list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitieu_dialog);
        init();
        setEvent();
    }

    private void setEvent() {
        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private void init() {
        lvDS = (ListView) findViewById(R.id.lvDS);
        imgCancel = (ImageView) findViewById(R.id.imgCancel);
        chiTieuAdapter = new ChiTieuAdapter(context,list);
        lvDS.setAdapter(chiTieuAdapter);
    }

}

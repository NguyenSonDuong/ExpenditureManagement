package com.group1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.group1.LopCSDL.LoaiVayTra;
import com.group1.LopCSDL.ThongTinVayTra;
import com.group1.expendituremanagement.R;

import java.util.ArrayList;

public class VayTraAdapter extends BaseAdapter {

    ArrayList<LoaiVayTra> arrayList;
    Context context;

    public VayTraAdapter(ArrayList<LoaiVayTra> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class ViewHoder{
        LinearLayout lnlMain;
        TextView tvName, tvSoTien, tvGhiChu;
        ImageView ivShowVayTra;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHoder hoder;
        if(view == null){
            hoder = new ViewHoder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_list_view_vay_tra, null);

            hoder.lnlMain = view.findViewById(R.id.lnlMain);
            hoder.tvName = view.findViewById(R.id.tvVayTra);

            view.setTag(hoder);

        }else {
            hoder = (ViewHoder) view.getTag();
        }

        LoaiVayTra vayTra = arrayList.get(i);

        hoder.tvName.setText(vayTra.getLoaiVayTra());
        hoder.tvSoTien.setText(vayTra.getSoTien()+"");
        hoder.tvGhiChu.setText(vayTra.getGhiChu());


        return view;
    }
}

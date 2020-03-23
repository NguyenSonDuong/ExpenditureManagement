package com.group1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.group1.LopCSDL.ThongTinChiTieu;
import com.group1.LopCSDL.ThongTinVayTra;
import com.group1.expendituremanagement.R;

import java.util.ArrayList;

public class VayAdapter extends BaseAdapter {
    Context context;
    ArrayList<ThongTinVayTra> list = new ArrayList<>();

    public VayAdapter(Context context, ArrayList<ThongTinVayTra> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoder viewHoder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_show_data,null);
            viewHoder = new ViewHoder();
            viewHoder.tvMoney = (TextView) convertView.findViewById(R.id.tvMoney);
            viewHoder.tvType = (TextView) convertView.findViewById(R.id.tvType);
            viewHoder.tvNote = (TextView) convertView.findViewById(R.id.tvNote);
            convertView.setTag(viewHoder);
        }else {
            viewHoder = (ViewHoder) convertView.getTag();
        }
        ThongTinVayTra thongTinVayTra = list.get(position);
        viewHoder.tvMoney.setText(thongTinVayTra.sotienvay+" đ");
        viewHoder.tvType.setText(thongTinVayTra.loaigiaodich);
        viewHoder.tvType.setText(thongTinVayTra.ghichugiaodich);
        return convertView;
    }
    class ViewHoder{
        TextView tvMoney,tvType,tvNote;
    }
}

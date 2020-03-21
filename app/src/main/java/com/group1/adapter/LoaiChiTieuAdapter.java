package com.group1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.group1.LopCSDL.LoaiChiTieu;
import com.group1.expendituremanagement.R;

import java.util.ArrayList;

public class LoaiChiTieuAdapter extends BaseAdapter {
    ArrayList<LoaiChiTieu> list;
    Context context;

    public LoaiChiTieuAdapter(ArrayList<LoaiChiTieu> list, Context context) {
        this.list = list;
        this.context = context;
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
            viewHoder = new ViewHoder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_loaichitieu,null);
            viewHoder.tvMoney = convertView.findViewById(R.id.tvMoney);
            viewHoder.tvNameType = convertView.findViewById(R.id.tvNameType);
            viewHoder.tvTime = convertView.findViewById(R.id.tvTime);
            viewHoder.imgShow = convertView.findViewById(R.id.imgShow);
            convertView.setTag(viewHoder);
        }else {
            viewHoder = (ViewHoder) convertView.getTag();
        }
        LoaiChiTieu item = list.get(position);
        viewHoder.tvNameType.setText(item.loaichitieu);
        viewHoder.tvMoney.setText(item.sotien+"");
        viewHoder.tvTime.setText(item.end_buy_time);
        return convertView;
    }
    class ViewHoder{
        TextView tvNameType, tvMoney, tvTime;
        ImageView imgShow;
    }
}

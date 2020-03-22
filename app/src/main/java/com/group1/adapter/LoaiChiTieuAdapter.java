package com.group1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.group1.LopCSDL.LoaiChiTieu;
import com.group1.expendituremanagement.R;

import java.util.ArrayList;
import java.util.Random;

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

    public int getRamdomIDColor(){
        Random random = new Random();
        ArrayList<Integer> li = new ArrayList<>();
        li.add(R.color.orange);
        li.add(R.color.purple);
        li.add(R.color.tile);
        li.add(R.color.dark_orange);
        li.add(R.color.purple_blue);
        li.add(R.color.dark_yellow);
        li.add(R.color.green);
        li.add(R.color.pink);
        li.add(R.color.red);
        li.add(R.color.yellow);
        return li.get(random.nextInt(10));
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
            viewHoder.lnMainShow = convertView.findViewById(R.id.lnMainShow);
            convertView.setTag(viewHoder);
        }else {
            viewHoder = (ViewHoder) convertView.getTag();
        }
        LoaiChiTieu item = list.get(position);
        viewHoder.tvNameType.setText(item.loaichitieu);
        viewHoder.tvMoney.setText(item.sotien+"");
        viewHoder.tvTime.setText(item.end_buy_time);
        viewHoder.lnMainShow.setBackgroundColor(context.getResources().getColor(getRamdomIDColor()));
        return convertView;
    }
    class ViewHoder{
        TextView tvNameType, tvMoney, tvTime;
        ImageView imgShow;
        LinearLayout lnMainShow;
    }
}

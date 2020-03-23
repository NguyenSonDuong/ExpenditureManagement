package com.group1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.group1.LopCSDL.HoTroXuLyDataBase;
import com.group1.LopCSDL.KeyDatabase;
import com.group1.LopCSDL.LoaiChiTieu;
import com.group1.LopCSDL.LopCreat_Time;
import com.group1.LopCSDL.ThongTinChiTieu;
import com.group1.LopCSDL.XuLyDatabase;
import com.group1.dialog.ChiTieuDialog;
import com.group1.expendituremanagement.R;
import com.group1.server.XuLyServer;

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

    public int getRamdomIDColor(int i){
        ArrayList<Integer> li = new ArrayList<>();
        li.add(R.color.yellow);
        li.add(R.color.orange);
        li.add(R.color.purple);
        li.add(R.color.tile);
        li.add(R.color.dark_orange);
        li.add(R.color.purple_blue);
        li.add(R.color.green);
        li.add(R.color.pink);
        li.add(R.color.red);
        return li.get(i);
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
        final LoaiChiTieu item = list.get(position);
        viewHoder.tvNameType.setText(item.loaichitieu);
        viewHoder.tvMoney.setText(XuLyServer.formatMoney(item.sotien) +" đ");
        viewHoder.tvTime.setText(item.end_buy_time);
        viewHoder.lnMainShow.setBackgroundColor(context.getResources().getColor(getRamdomIDColor(position)));
        viewHoder.imgShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyDatabase xuLyDatabase = new XuLyDatabase(context, KeyDatabase.DATABASENAME_INFOR,null,1);
                ArrayList<ThongTinChiTieu> list = HoTroXuLyDataBase.layDLChiTieuByLoaiChiTieu(xuLyDatabase,item.loaichitieu, LopCreat_Time.ngayThang());
                ChiTieuDialog chiTieuDialog = new ChiTieuDialog(context,context,list);
                chiTieuDialog.show();
            }
        });
        return convertView;
    }
    class ViewHoder{
        TextView tvNameType, tvMoney, tvTime;
        ImageView imgShow;
        LinearLayout lnMainShow;
    }
}

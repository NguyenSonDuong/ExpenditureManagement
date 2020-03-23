package com.group1.expendituremanagement;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.group1.Fragment.FragmentAddChiTieu;
import com.group1.Fragment.FragmentAddVay;
import com.group1.Fragment.FragmentInformationUser;
import com.group1.Fragment.FragmentShowInfor;
import com.group1.Fragment.Fragment_Thong_Ke_Chi_Tieu;
import com.group1.Fragment.Fragment_Thong_Ke_Vay_Tra;
import com.group1.LopCSDL.HoTroXuLyDataBase;
import com.group1.LopCSDL.KeyDatabase;
import com.group1.LopCSDL.LopCreat_Time;
import com.group1.LopCSDL.ThongTinVayTra;
import com.group1.LopCSDL.XuLyDatabase;
import com.group1.adapter.ChiTieuAdapter;
import com.group1.adapter.VayAdapter;
import com.group1.server.XuLyServer;

import java.security.Key;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    HoTroXuLyDataBase hoTroXuLyDataBase;
//    XuLyDatabase xuLyDatabase;
    public static String KEY_ADD_VAY = "VAY";
    public static String KEY_ADD_CHITIEU = "CHITIEU";
    FrameLayout flN;
    FragmentManager fragmentManager;
    ListView listView;
    NavigationView navigationView;
    ImageView ivAdd;
    Button btnAddVay,btnAddChiTieu;
    DrawerLayout drowMain;
    FragmentAddChiTieu fragmentAddChiTieu;
    FragmentAddVay fragmentAddVay;
    FragmentShowInfor fragmentShowInfor;
    FragmentInformationUser fragmentInformationUser;
    Fragment_Thong_Ke_Chi_Tieu fragment_thong_ke_chi_tieu;
    Fragment_Thong_Ke_Vay_Tra fragment_thong_ke_vay_tra;
    private boolean iclick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setEvent();
    }

    private void setEvent() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case  R.id.itemttNguoiDung:
                        addFragment(fragmentInformationUser);
                        drowMain.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.itemDangXuat:
                        XuLyServer.setDataToFile(MainActivity.this,KeyDatabase.LOGIN_INFOR_NAMEFILE,KeyDatabase.LOGIN_OFFLINE_TOKEN,"");
                        Intent intent = new Intent(MainActivity.this,DangNhap.class);
                        startActivity(intent);
                        finish();
                        break;

                    case R.id.itemChiTieu:
                        addFragment(fragment_thong_ke_chi_tieu);
                        drowMain.closeDrawer(Gravity.LEFT);
                        break;

                    case R.id.itemVayTra:
                        addFragment(fragment_thong_ke_vay_tra);
                        drowMain.closeDrawer(Gravity.LEFT);
                        break;

                    default:
                        break;
                }

                return false;
            }
        });
        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(iclick) {
                    iclick = false;
                    return;
                };
                addFragment(fragmentShowInfor);

            }
        });
        ivAdd.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                iclick = true;
                Toast.makeText(MainActivity.this, "Đụ mé", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        btnAddVay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(fragmentAddVay);
            }
        });
        btnAddChiTieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                addFragment(fragmentAddChiTieu);
            }
        });


    }

    private void addFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(fragment.getTag());
        fragmentTransaction.replace(R.id.flN,fragment);
        fragmentTransaction.commit();
    }
    private void init() {
        fragmentAddChiTieu = new FragmentAddChiTieu(this);
        fragmentAddVay = new FragmentAddVay(this);
        fragmentShowInfor = new FragmentShowInfor(this);
        fragmentInformationUser = new FragmentInformationUser(this);
        fragment_thong_ke_chi_tieu = new Fragment_Thong_Ke_Chi_Tieu(this);
        fragment_thong_ke_vay_tra = new Fragment_Thong_Ke_Vay_Tra(this);
        flN = (FrameLayout) findViewById(R.id.flN);
        fragmentManager = getSupportFragmentManager();
        btnAddChiTieu = (Button) findViewById(R.id.btnAddChiTieu);
        btnAddVay = (Button) findViewById(R.id.btnAddVay);
        navigationView = (NavigationView) findViewById(R.id.naViGation);
        ivAdd = (ImageView) findViewById(R.id.ivAdd1);
        drowMain = (DrawerLayout) findViewById(R.id.drowMain);
        addFragment(fragmentShowInfor);

        XuLyDatabase xuLyDatabase = new XuLyDatabase(this, KeyDatabase.DATABASENAME_INFOR,null,1);
        ArrayList<ThongTinVayTra> list = HoTroXuLyDataBase.layDLVayTra(xuLyDatabase);



        View view = navigationView.getHeaderView(0);
        TextView tvTen = view.findViewById(R.id.tvTen);
        TextView tvNgaySinh = view.findViewById(R.id.tvNgaySinh);
        TextView tvTongTien = view.findViewById(R.id.tvTongTien);
        tvTen.setText(XuLyServer.getNicknameOffline(this));
        tvNgaySinh.setText(HoTroXuLyDataBase.getInforUser(new XuLyDatabase(this, KeyDatabase.DATABASENAME,null,1),XuLyServer.getNicknameOffline(this)).getNgaySinh());
        tvTongTien.setText(XuLyServer.formatMoney(HoTroXuLyDataBase.getChiTieuTheoNgay(new XuLyDatabase(this, KeyDatabase.DATABASENAME_INFOR,null,1),LopCreat_Time.ngayThang()))+" đ");
    }

    private void swichFragment(Fragment fragment){

    }


}

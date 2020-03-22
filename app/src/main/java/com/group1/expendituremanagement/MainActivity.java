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
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.group1.Fragment.FragmentAddChiTieu;
import com.group1.Fragment.FragmentAddVay;
import com.group1.Fragment.FragmentInformationUser;
import com.group1.Fragment.FragmentShowInfor;
import com.group1.LopCSDL.HoTroXuLyDataBase;
import com.group1.LopCSDL.KeyDatabase;
import com.group1.LopCSDL.LopCreat_Time;
import com.group1.LopCSDL.ThongTinVayTra;
import com.group1.LopCSDL.XuLyDatabase;
import com.group1.server.XuLyServer;

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
                if(menuItem.getItemId() == R.id.itemttNguoiDung){
                    addFragment(fragmentInformationUser);
                    drowMain.closeDrawer(Gravity.LEFT);
                }else if(menuItem.getItemId() == R.id.itemDangXuat){
                    XuLyServer.setDataToFile(MainActivity.this,KeyDatabase.LOGIN_INFOR_NAMEFILE,KeyDatabase.LOGIN_OFFLINE_TOKEN,"");
                    Intent intent = new Intent(MainActivity.this,DangNhap.class);
                    startActivity(intent);
                    finish();
                }
                return false;
            }
        });
        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(fragmentShowInfor);
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
    }

    private void swichFragment(Fragment fragment){

    }


}

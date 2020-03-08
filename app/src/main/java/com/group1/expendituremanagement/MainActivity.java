package com.group1.expendituremanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.group1.LopCSDL.HoTroXuLyDataBase;
import com.group1.LopCSDL.LopCreat_Time;
import com.group1.LopCSDL.XuLyDatabase;

public class MainActivity extends AppCompatActivity {

   HoTroXuLyDataBase hoTroXuLyDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // hoTroXuLyDataBase.ttNguoiDung(null, this, "dlNguoiDung.sqlite");

    }


}

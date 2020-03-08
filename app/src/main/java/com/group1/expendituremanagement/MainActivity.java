package com.group1.expendituremanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
<<<<<<< HEAD
import android.widget.Toast;

import com.group1.LopCSDL.HoTroXuLyDataBase;
=======
import android.util.Log;
import android.widget.Toast;

import com.group1.LopCSDL.HoTroXuLyDataBase;
import com.group1.LopCSDL.LopCreat_Time;
>>>>>>> c24cf1a70906cb14cb882e393002a845aa71bd0c
import com.group1.LopCSDL.XuLyDatabase;

public class MainActivity extends AppCompatActivity {

   HoTroXuLyDataBase hoTroXuLyDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
    }



=======

       // hoTroXuLyDataBase.ttNguoiDung(null, this, "dlNguoiDung.sqlite");

    }


>>>>>>> c24cf1a70906cb14cb882e393002a845aa71bd0c
}

package com.group1.expendituremanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SyncData extends AppCompatActivity {

    TextView tvTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync_data);
        init();
        setEvent();
    }

    private void setEvent() {

    }

    private void init() {
    }


}

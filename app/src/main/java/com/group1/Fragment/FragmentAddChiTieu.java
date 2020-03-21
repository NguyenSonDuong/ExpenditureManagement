package com.group1.Fragment;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.group1.expendituremanagement.R;

public class FragmentAddChiTieu  extends Fragment {

    Context context;

    public FragmentAddChiTieu(Context context) {
        this.context = context;
    }

    public FragmentAddChiTieu(int contentLayoutId, Context context) {
        super(contentLayoutId);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(context).inflate(R.layout.add_chitieu,container,false);
        return view;
    }
}

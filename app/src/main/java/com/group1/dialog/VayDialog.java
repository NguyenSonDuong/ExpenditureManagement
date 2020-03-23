package com.group1.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.group1.expendituremanagement.R;

public class VayDialog extends Dialog {
    public VayDialog(@NonNull Context context) {
        super(context);
    }

    public VayDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected VayDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vay_dialog);
    }
}

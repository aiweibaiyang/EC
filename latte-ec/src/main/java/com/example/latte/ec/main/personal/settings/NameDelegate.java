package com.example.latte.ec.main.personal.settings;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.latte.delegates.LatteDelegate;
import com.example.latte.ec.R;

public class NameDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_name;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}

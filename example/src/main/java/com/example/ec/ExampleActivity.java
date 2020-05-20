package com.example.ec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.latte.activities.ProxyActivity;
import com.example.latte.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}

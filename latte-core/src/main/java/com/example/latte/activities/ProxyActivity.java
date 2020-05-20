package com.example.latte.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.ContentFrameLayout;

import com.example.latte.R;
import com.example.latte.delegates.LatteDelegate;

import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportActivityDelegate;

public abstract class ProxyActivity extends SupportActivity {

    private final SupportActivityDelegate DELEGATE = new SupportActivityDelegate(this);

    public abstract LatteDelegate setRootDelegate();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DELEGATE.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    private void initContainer(@Nullable Bundle savedInstanceState) {//初始化视图
        @SuppressLint("RestrictedApi") final ContentFrameLayout container = new ContentFrameLayout(this);
        container.setId(R.id.delegate_container);
        setContentView(container);
        if (savedInstanceState == null) {
            DELEGATE.loadRootFragment(R.id.delegate_container, setRootDelegate());//SupportActivity中独有的方法，也就是Fragment库中的方法
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}

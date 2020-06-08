package com.example.latte.util.callback;

import androidx.annotation.Nullable;

public interface IGlobalCallback<T> {

    void executeCallback(@Nullable T args);
}


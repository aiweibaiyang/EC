package com.example.latte.net.interceptors;

import androidx.annotation.NonNull;

import com.example.latte.util.storage.LattePreference;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public final class AddCookieInterceptor implements Interceptor {
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        final Request.Builder builder = chain.request().newBuilder();
        Observable.just(LattePreference.getCustomAppProfile("cookie"))
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String cookie) throws Exception {
                        //给原生Api请求附带上WebView拦截下来的Cookie
                        builder.addHeader("cookie",cookie);
                    }
                });
        return chain.proceed(builder.build());
    }
}

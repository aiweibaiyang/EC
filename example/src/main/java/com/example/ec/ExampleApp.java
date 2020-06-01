package com.example.ec;

import android.app.Application;

import com.example.ec.event.TestEvent;
import com.example.latte.app.Latte;
import com.example.latte.ec.database.DatabaseManager;
import com.example.latte.ec.icon.FontEcModule;
import com.example.latte.net.interceptors.DebugInterceptor;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://192.168.1.103:8081/RestServer/api/")
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withInterceptor(new DebugInterceptor("test",R.raw.test))
                .withWeChatAppId("")
                .withWeChatAppSecret("")
                .withJavascriptInterface("latte")
                .withWebEvent("test",new TestEvent())
                .configure();
        DatabaseManager.getInstance().init(this);


    }
}

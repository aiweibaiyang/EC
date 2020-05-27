package com.example.ec.generator;

import com.example.annotations.AppRegisterGenerator;
import com.example.latte.wechat.templates.AppRegisterTemplate;

@AppRegisterGenerator(
        packageName = "com.example.ec",
        registerTemplete = AppRegisterTemplate.class
)
public interface AppRegister {
}

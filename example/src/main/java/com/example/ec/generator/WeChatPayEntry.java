package com.example.ec.generator;

import com.example.annotations.PayEntryGenerator;
import com.example.latte.wechat.templates.WXPayEntryTemplate;

@PayEntryGenerator(
        packageName = "com.example.ec",
        payEntryTemplete = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}

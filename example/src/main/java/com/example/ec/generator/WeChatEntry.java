package com.example.ec.generator;

import com.example.annotations.EntryGenerator;
import com.example.latte.wechat.templates.WXEntryTemplate;

@EntryGenerator(
        packageName = "com.example.ec",
        entryTemplete = WXEntryTemplate.class
)
public interface WeChatEntry {
}

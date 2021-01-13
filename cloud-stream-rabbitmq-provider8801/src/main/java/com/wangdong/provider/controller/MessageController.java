package com.wangdong.provider.controller;

import com.wangdong.commons.result.R;
import com.wangdong.provider.service.IMessageProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
public class MessageController {

    private final IMessageProvider messageProvider;

    @GetMapping
    public R send() {
        return R.success(messageProvider.send());
    }

}

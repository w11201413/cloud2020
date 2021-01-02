package com.wangdong.consumer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ConsumerController {

    @GetMapping
    public String test() {
        return "1";
    }

}

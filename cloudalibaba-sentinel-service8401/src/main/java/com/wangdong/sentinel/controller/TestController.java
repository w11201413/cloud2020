package com.wangdong.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wangdong.commons.result.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/testA")
    public R testA() {
        return R.success("ok");
    }

    @GetMapping("/testB")
    public R testB() {
        return R.success("ok");
    }

    @GetMapping("/testHotkey")
    @SentinelResource(value = "testHotkey", blockHandler = "dealTestHotkey")
    public R testC(@RequestParam(required = false) String p1, @RequestParam(required = false) String p2) {
        return R.success("C");
    }

    public R dealTestHotkey(String p1, String p2, BlockException exception) {
        return R.success("block");
    }

}

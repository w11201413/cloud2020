package com.wangdong.commons.autoConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.wangdong.commons.exception.handler"})
public class ScanAutoConfiguration {
}

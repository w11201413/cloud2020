package com.wangdong.eureka.controller;

import com.wangdong.commons.result.R;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

/**
 * 服务发现
 * @author wangdong
 * @date 2021-01-03
 */
@RestController
@RequestMapping("/discovery")
@RequiredArgsConstructor
public class DiscoveryController {

    private final DiscoveryClient discoveryClient;

    @GetMapping
    public R getDiscoveryInfo() {
        return R.success(discoveryClient.getServices().stream().flatMap(v -> discoveryClient.getInstances(v).stream())
                .collect(Collectors.groupingBy(ServiceInstance::getServiceId, Collectors.mapping(ServiceInstance::getInstanceId, Collectors.toList()))));
    }

}

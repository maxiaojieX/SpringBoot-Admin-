package com.springboot.feign.service;

import com.springboot.feign.service.impl.AppServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/4/25.
 */
@FeignClient(name = "app-server",fallback = AppServiceImpl.class)
public interface AppService {

    @GetMapping("/appServer")
    String appServer();

}

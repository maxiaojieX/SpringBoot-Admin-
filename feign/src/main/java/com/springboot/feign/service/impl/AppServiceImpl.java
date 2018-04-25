package com.springboot.feign.service.impl;

import com.springboot.feign.service.AppService;
import org.springframework.stereotype.Component;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/4/25.
 */
@Component
public class AppServiceImpl implements AppService {
    @Override
    public String appServer() {
        return "熔断测试";
    }
}

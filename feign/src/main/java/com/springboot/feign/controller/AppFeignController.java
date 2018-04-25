package com.springboot.feign.controller;

import com.springboot.feign.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaojie.Ma on 2018/4/25.
 */
@RestController
public class AppFeignController {

    @Autowired
    private AppService appService;
    @RequestMapping("/guest/appServer")
    public String appServer() {
        return appService.appServer();
    }

}

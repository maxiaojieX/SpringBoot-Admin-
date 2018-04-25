package com.springboot.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/4/25.
 */
@RestController
public class ServerController {

    @RequestMapping(value = "/appServer")
    public String appServer() {
        return "AppServer execution";
    }

}

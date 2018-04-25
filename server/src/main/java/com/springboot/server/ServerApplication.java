package com.springboot.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/4/24.
 */
@SpringBootApplication
@EnableDiscoveryClient
//开启断路器装配
@EnableCircuitBreaker
//开启feign client
@EnableFeignClients
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class,args);
    }

}

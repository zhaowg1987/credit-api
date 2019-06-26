package com.jiukeshuke.creditapi;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

// 启用feign进行远程调用
@EnableDistributedTransaction
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class CreditApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditApiApplication.class, args);
    }

}

package com.rotec.aiservicesrotec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;

@SpringBootApplication
@EntityScan("com.rotec.aiservicesrotec.entity")
@EnableScheduling
@EnableDiscoveryClient
@EnableDubbo
public class AiServicesRotecApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiServicesRotecApplication.class, args);
    }

}

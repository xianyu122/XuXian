package com.xuxian;

import com.xuxian.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class SpitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpitApplication.class);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}

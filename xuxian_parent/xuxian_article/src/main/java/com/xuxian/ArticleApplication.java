package com.xuxian;

import com.xuxian.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ArticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }

}

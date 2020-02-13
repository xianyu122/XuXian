package com.xuxian.config;

import com.xuxian.handler.JwtHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class JwtConfig extends WebMvcConfigurationSupport {

    @Autowired
    private JwtHandler jwtHandler;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtHandler)
                .addPathPatterns("/**")
                .excludePathPatterns("/**/login");
    }
}

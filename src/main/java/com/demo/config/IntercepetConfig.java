package com.demo.config;

import com.demo.intercept.shortUrlIntercept;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.logging.Logger;

@Configuration
public class IntercepetConfig implements WebMvcConfigurer {

    @Autowired
    private shortUrlIntercept shortUrlIntercept1;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(shortUrlIntercept1).addPathPatterns("/**");
    }
}

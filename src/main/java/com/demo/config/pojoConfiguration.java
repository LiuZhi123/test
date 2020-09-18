package com.demo.config;

import com.demo.entity.TestPojo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class pojoConfiguration {
    @Bean
    public void SetPojo(TestPojo testPojo){
        testPojo.setName("3123");
    }
}

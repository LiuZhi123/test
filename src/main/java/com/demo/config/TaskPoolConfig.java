//package com.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import java.util.concurrent.Executor;
//
//@Configuration
//@EnableAsync
//public class TaskPoolConfig {
//    @Bean("taskExecutor")
//    public Executor taskExecutor(){
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(10);
//        executor.setMaxPoolSize(20);
//        executor.setQueueCapacity(9999);
//        executor.setKeepAliveSeconds(60);
//        executor.setThreadNamePrefix("testExecutor--");
//        return executor;
//    }
//}

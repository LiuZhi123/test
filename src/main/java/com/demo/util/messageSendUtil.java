package com.demo.util;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.stereotype.Component;

@Component
public class messageSendUtil {
    private final static String group = "test-group";
    private final static String nameSever = "localhost:9876";

    public  void messageSendUtil(){
        DefaultMQProducer producer = new DefaultMQProducer(group);
        producer.setNamesrvAddr(nameSever);

    }


}

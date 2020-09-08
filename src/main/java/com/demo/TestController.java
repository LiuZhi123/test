package com.demo;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.demo.entity.Url;
import com.demo.service.shortUrlService;
import com.demo.util.aopConfig;
import com.demo.util.shortUrlUtil;
import com.demo.util.socketUtil;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.soap.SAAJResult;
import java.io.IOException;
import java.util.Random;

@RestController
@RequestMapping("/config")
public class TestController {
    private static  final Logger logger = LoggerFactory.getLogger(TestController.class);
    @Resource
    private RocketMQTemplate rocketMQTemplate;
    @Resource
    private shortUrlUtil shortUrl1;
    @Resource
    private shortUrlService shortUrlService;
    @NacosValue(value = "${local:false}",autoRefreshed = true)
    private String local;
    @Value("${nacos.config.server-addr}")
    private String name;
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String get(){
        return local;
    }
    @RequestMapping("/send")
    public void send(@RequestParam String message){
//        rocketMQTemplate.convertAndSend();
    }
    @aopConfig
    @Async("taskExecutor")
    @RequestMapping("/short")
    public String shortUrl(@RequestParam String url){
        String[] urls = shortUrl1.shortUrl(url);
        Url url1 = new Url();
        url1.setLong_url(url);
        int i  = new Random().nextInt(3);
        url1.setShort_url(urls[i]);
        shortUrlService.insert(url1);
        logger.info(Thread.currentThread().getName()+"==="+urls[i]);
        return urls[i];
    }

    @RequestMapping("/socket")
    public void testSocket(@RequestParam String message) throws IOException {
        socketUtil socketUtil = new socketUtil();
        socketUtil.sendTcp(message);
        socketUtil.reciveTcp();
        System.out.println("发送接受数据实验成功！");
    }
}

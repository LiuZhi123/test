package com.demo;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.demo.entity.Url;
import com.demo.service.shortUrlService;
import com.demo.util.shortUrlUtil;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.xml.soap.SAAJResult;
import java.util.Random;

@Controller
@RequestMapping("/config")
@ResponseBody
public class TestController {
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
    @RequestMapping("/short")
    public String shortUrl(@RequestParam String url){
        String[] urls = shortUrl1.shortUrl(url);
        Url url1 = new Url();
        url1.setLong_url(url);
        url1.setShort_url(urls[0]);
        shortUrlService.insert(url1);
        return urls[0];
    }
}

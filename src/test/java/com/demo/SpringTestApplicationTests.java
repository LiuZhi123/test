package com.demo;

import com.demo.entity.Url;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.annotation.security.RunAs;
import javax.sql.DataSource;
import java.util.*;

@SpringBootTest(classes = SpringTestApplication.class)
@RunWith(SpringRunner.class)
class SpringTestApplicationTests {

    @Autowired
    ApplicationContext ioc;

//    @Qualifier("datasource1")
//    @Resource
//    DataSource dataSource1;
    @Test
    public void getInfo(){
        boolean b = ioc.containsBean("datasource1");
        System.out.println(b);
    }

    @Test
    public void printInfo(){
        HashSet hashSet = new HashSet();
        Url url1 = new Url(1,"123","123");
        Url url2 = new Url(1,"123","123");
        hashSet.add(url1);
        hashSet.add(url2);
        System.out.println("========"+hashSet.size());
//        String str = null;
//        System.out.println(String.valueOf(str));
//        System.out.println("============"+str.toString());
    }

}

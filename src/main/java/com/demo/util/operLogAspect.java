package com.demo.util;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class operLogAspect {
    @Pointcut("@annotation(com.demo.util.aopConfig)")
    public void  operExcepetionLog(){}

    @Pointcut("within(com.demo.TestController)")
    public void operLogPoint(){}

    @Before(value = "operLogPoint()")
    public void BerforeTestController(){
        System.out.println(".....即将进入TestController执行方法");
    }

    @AfterThrowing(value = "operExcepetionLog()")
    public void AfterThrowException(){
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=--=程序异常");
    }
}

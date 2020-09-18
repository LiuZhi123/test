package com.demo.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class beanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public beanFactoryPostProcessor(){
        super();
        System.out.println("beanFactoryProcessor实例化！");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("TestPojo");
        beanDefinition.getPropertyValues().addPropertyValue("id",1);
    }
}

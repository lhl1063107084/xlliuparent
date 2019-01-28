package com.xlliu.service.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liuxiaolun
 * @Description: TODO
 * @date 2018-10-31 15:42:10
 **/
//@Component
public class MyBeanPostProcesser implements BeanPostProcessor {
    private static final Logger log = LoggerFactory.getLogger(MyBeanPostProcesser.class);
    private Map map = new ConcurrentHashMap(100);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean" + bean);
        System.out.println("beanName" + beanName);

        return bean;
    }
}

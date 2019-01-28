package com.xlliu.service.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author liuxiaolun
 * @Description: controller增加日志代理
 * @date 2018-10-31 15:44:29
 **/
public class MyProxy implements InvocationHandler {
    private static final Logger log = LoggerFactory.getLogger(MyProxy.class);
    private Object object;

    public MyProxy(Object o) {
        this.object = o;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method);
        System.out.println(args);
        System.out.println("begin================");
        Object invoke = method.invoke(object, args);
        System.out.println("end=================");

        new ArrayList();
        return invoke;
    }



    // 反射
}

package com.xlliu.service.spring.beanpostprocess;

import org.springframework.stereotype.Service;

/**
 * @author liuxiaolun
 * @Description: TODO
 * @date 2018-10-31 14:01:05
 **/
@Service
public class HelloServiceImplV1 implements HelloService {

    @Override
    public void sayHello() {
        System.out.println("我是V1Hello----");
    }

    @Override
    public void sayHi() {
        System.out.println("我是V1Hi----");
    }
}

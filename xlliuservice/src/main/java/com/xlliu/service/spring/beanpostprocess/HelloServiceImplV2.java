package com.xlliu.service.spring.beanpostprocess;

import org.springframework.stereotype.Service;

/**
 * @author liuxiaolun
 * @Description: TODO
 * @date 2018-10-31 14:01:57
 **/
@Service
public class HelloServiceImplV2 implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("我是V2Hello----");
    }

    @Override
    public void sayHi() {
        System.out.println("我是V2Hi----");
    }
}

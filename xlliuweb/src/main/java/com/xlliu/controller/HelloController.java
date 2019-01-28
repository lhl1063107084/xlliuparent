package com.xlliu.controller;

import com.xlliu.service.spring.beanpostprocess.HelloService;
import com.xlliu.service.spring.beanpostprocess.RoutingInjected;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxiaolun
 * @Description: TODO
 * @date 2018-10-31 14:03:20
 **/
@RestController
@RequestMapping("/test")
public class HelloController {
    @RoutingInjected
    private HelloService helloService;

    @PostMapping("/bean/post/process")
    public void sayHello() {
        this.helloService.sayHello();
    }

    public void sayHi() {
        this.helloService.sayHi();
    }

}

package com.xlliu.service.spring.beanpostprocess;

/**
 * @author liuxiaolun
 * @Description: TODO
 * @date 2018-10-31 14:00:08
 **/
@RoutingSwitch("hello.switch")
public interface HelloService {
    //A->V2  B->V1
    @RoutingSwitch("B")
    void sayHello();

    void sayHi();
}

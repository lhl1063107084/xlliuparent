package com.xlliu.service.spring.beanpostprocess.parentandson;

/**
 * @author liuxiaolun
 * @Description: TODO
 * @date 2018-11-12 18:11:34
 **/
public abstract class Son1 extends Parent {
    @Override
    public void doSomething() {
        System.out.println("456");
    }

    @Override
    public void show() {

    }
}

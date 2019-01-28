package com.xlliu.service.spring.beanpostprocess.parentandson;

/**
 * @author liuxiaolun
 * @Description: TODO
 * @date 2018-11-12 17:42:50
 **/
public abstract class Son extends Parent {
    @Override
    public void doSomething() {
        System.out.println("123");
    }

    //重写parent方法
    @Override
    public void show() {
        System.out.println("我是show");
    }


}

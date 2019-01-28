package com.xlliu.service.spring.beanpostprocess.parentandson;

/**
 * @author liuxiaolun
 * @Description: TODO
 * @date 2018-11-12 17:41:33
 **/
public abstract class Parent implements Father {
    /**
     * 1.抽象类实现一个接口自己及其子类必须至少有一处要实现其接口方法.
     * 2.一个类(孙子辈)继承一个抽象类(爷爷辈),则要实现其全部的抽象方法,没必要非得自己实现(儿子辈)实现也是可以的。
     */
    @Override
    public abstract void show(); //重写father接口的方法

    public abstract void doSomething();

    public void say() {
        doSomething();
        System.out.println("www.chinoukin.com");
    }
}

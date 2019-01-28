package com.xlliu.service.spring.beanpostprocess.parentandson;

/**
 * @author liuxiaolun
 * @Description: TODO
 * @date 2018-11-13 11:34:00
 **/
public class Son2 implements Father {
    @Override
    public void show() {
        System.out.println("我是show");
    }
}

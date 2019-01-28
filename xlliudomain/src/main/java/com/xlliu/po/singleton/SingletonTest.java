package com.xlliu.po.singleton;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liuxiaolun
 * @Description: 单例模式测试
 * @date 2018-11-10 12:42:39
 **/
@Getter
@Setter
public class SingletonTest {
    private SingletonTest() {

    }

    /**
     * 饿汉式
     */
//    private final static SingletonTest singletonTest = new SingletonTest();

    /**
     * 懒汉式
     */
    private static volatile SingletonTest singletonTest = null;

//
//    public static SingletonTest getInstance() {
//
//        if (singletonTest == null) {
//            //线程 A、B
//            synchronized (SingletonTest.class) { //线程A
//                if (singletonTest == null) {
//                    singletonTest = new SingletonTest();
//                }
//            }
//
//        }
//
//        return singletonTest;
//    }

    /**
     * 内部类
     */

    public static class innerClass {
        private static final SingletonTest singletonTest = new SingletonTest();
    }

    public static SingletonTest getInstance() {
        return innerClass.singletonTest;
    }





}

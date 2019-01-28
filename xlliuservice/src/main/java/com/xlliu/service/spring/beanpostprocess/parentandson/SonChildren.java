package com.xlliu.service.spring.beanpostprocess.parentandson;

/**
 * @author liuxiaolun
 * @Description: TODO
 * @date 2018-11-12 17:54:18
 **/
public class SonChildren extends Son {
    public static void main(String a[]) {
        SonChildren sonChildren = new SonChildren();
        sonChildren.say();
    }


  //  SonChildren -> Son -> Parent -> father
}

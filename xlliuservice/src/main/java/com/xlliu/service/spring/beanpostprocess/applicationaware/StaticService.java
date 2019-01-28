package com.xlliu.service.spring.beanpostprocess.applicationaware;

/**
 * @author liuxiaolun
 * @Description: 测试
 * @date 2018-10-30 18:29:48
 **/
public class StaticService {
    public static String test() {
        TestService testService = (TestService) SpringContextHolder.getContext().getBean("testService");
        return testService.printStr("刘小轮");
    }


}


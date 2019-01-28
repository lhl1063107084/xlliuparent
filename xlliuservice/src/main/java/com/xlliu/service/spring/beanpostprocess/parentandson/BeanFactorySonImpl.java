package com.xlliu.service.spring.beanpostprocess.parentandson;

/**
 * @author liuxiaolun
 * @Description: TODO
 * @date 2018-11-13 15:22:44
 **/
public class BeanFactorySonImpl implements BeanFactorySon {
    @Override
    public Object getType() {
        System.out.println("123132");
        return null;
    }
}

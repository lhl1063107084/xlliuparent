package com.xlliu.po.clone;

/**
 * @author liuxiaolun
 * @Description: 原型对象01
 * @date 2018-11-07 15:32:52
 **/
public class PrototypePattern01 implements CloneFactory {
    @Override
    public CloneFactory clone() {
        return new PrototypePattern01();
    }
}

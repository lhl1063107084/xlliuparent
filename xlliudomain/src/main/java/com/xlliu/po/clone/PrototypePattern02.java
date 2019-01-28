package com.xlliu.po.clone;

/**
 * @author liuxiaolun
 * @Description: 原型对象02
 * @date 2018-11-07 15:33:40
 **/
public class PrototypePattern02 implements CloneFactory {
    @Override
    public CloneFactory clone() {
        return new PrototypePattern02();
    }
}

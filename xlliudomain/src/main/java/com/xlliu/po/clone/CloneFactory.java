package com.xlliu.po.clone;

/**
 * @author liuxiaolun
 * @Description: 原型工厂
 * @date 2018-11-07 15:31:20
 **/
public interface CloneFactory extends Cloneable {
    CloneFactory clone();
}

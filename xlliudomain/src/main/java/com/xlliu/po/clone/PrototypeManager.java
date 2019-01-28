package com.xlliu.po.clone;

/**
 * @author liuxiaolun
 * @Description: 原型管理器/单例
 * @date 2018-11-07 15:34:25
 **/
public class PrototypeManager {
    private PrototypeManager() {
    }

    private static PrototypeManager prototypeManager = new PrototypeManager();

    public static PrototypeManager getPrototypeManager() {
        return prototypeManager;
    }


    public static CloneFactory getPrototypeClone(CloneFactory PrototypePattern) {

        return PrototypePattern.clone();
    }

}

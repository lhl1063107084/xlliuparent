package com.xlliu.po;


import com.xlliu.po.clone.PrototypeManager;
import com.xlliu.po.clone.PrototypePattern01;

/**
 * @author liuxiaolun
 * @Description: TODO
 * @date 2018-11-08 20:31:51
 **/
public class Test01 {
    public static void main(String a[]) throws Exception {
//        Map<String, String> hashMap = new HashMap<>();
//
//        hashMap.put("1", "1");
//        hashMap.put("2", "2");
//        hashMap.put("3", "3");
//        hashMap.put("4", "4");
//        hashMap.put("5", "5");
//        hashMap.put("6", "6");
//        hashMap.put("7", "7");
//        hashMap.put("8", "8");
//        hashMap.put("9", "9");
//        hashMap.put("10", "10");
//        hashMap.put("11", "11");
//        hashMap.put("12", "12");    //key = 12 会和 key = 1 碰撞
//        hashMap.put("13", "13");
//
//
//        //第一次扩容 容量16  极限容量16*0.75f = 12
//
//        //第二次扩容 上一次的容量 < < 1 = 16*2 = 32 极限容量 上一次的极限容量 < < 1 = 12*2 = 24
//


        PrototypeManager.getPrototypeClone(new PrototypePattern01());
    }

}

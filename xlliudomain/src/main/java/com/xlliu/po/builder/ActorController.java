package com.xlliu.po.builder;

/**
 * @author liuxiaolun
 * @Description: 指挥者/获取产品
 * @date 2018-11-07 16:58:53
 **/
public class ActorController {

    public static void main(String a[]) {
            //客户端 /入参为创建者,一个创建者产生一个产品
            AbstractActorBuilder actorBuilder = new ActorBuilder01();
            Actor actor = actorBuilder.buildName("刘小轮").buildAge("25").buildSex("男").buildHeight("178cm").build();
            System.out.println(actor);
    }


}

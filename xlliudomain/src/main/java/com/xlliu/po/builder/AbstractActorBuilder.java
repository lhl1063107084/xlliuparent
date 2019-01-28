package com.xlliu.po.builder;

/**
 * @author liuxiaolun
 * @Description: 抽象创建者
 * @date 2018-11-07 16:50:30
 **/
public interface AbstractActorBuilder {
    AbstractActorBuilder buildName(String name);

    AbstractActorBuilder buildSex(String sex);

    AbstractActorBuilder buildAge(String age);

    AbstractActorBuilder buildHeight(String height);

    Actor build();
}

package com.xlliu.po.builder;

/**
 * @author liuxiaolun
 * @Description: 具体创建者01
 * @date 2018-11-07 16:54:52
 **/
public class ActorBuilder01 implements AbstractActorBuilder {
    private String name;

    private String sex;

    private String age;

    private String height;


    @Override
    public AbstractActorBuilder buildName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public AbstractActorBuilder buildSex(String sex) {
        this.sex = sex;
        return this;
    }

    @Override
    public AbstractActorBuilder buildAge(String age) {
        this.age = age;
        return this;
    }

    @Override
    public AbstractActorBuilder buildHeight(String height) {
        this.height = height;
        return this;
    }

    @Override
    public Actor build() {
        return new Actor(name, age, sex, height);
    }

}

package com.xlliu.service.chaintable;

import lombok.*;

/**
 * @author liuxiaolun
 * @Description: 双向链表基础类
 * @date 2018-11-20 16:51:31
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LinkLy {
    private String id;
    private String name;
    private LinkLy next;
    private LinkLy previous;

    @Override
    public String toString() {
        return "LinkLy{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", next=" + next;
    }

    public void showLinkInfo() {
        System.out.println("链表id:" + id + ",链表名称:" + name);
    }



}

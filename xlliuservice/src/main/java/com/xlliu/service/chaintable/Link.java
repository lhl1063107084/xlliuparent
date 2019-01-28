package com.xlliu.service.chaintable;

import lombok.*;

/**
 * @author liuxiaolun
 * @Description: 链表基础类
 * @date 2018-11-19 15:36:07
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    private String id;
    private String name;
    private Link next;

    public void showLinkInfo() {
        System.out.println("链表id:" + id + ",链表名称:" + name);
    }

}

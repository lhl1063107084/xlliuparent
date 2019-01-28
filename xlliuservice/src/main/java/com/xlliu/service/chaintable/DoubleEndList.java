package com.xlliu.service.chaintable;

import lombok.Getter;
import lombok.ToString;

/**
 * @author liuxiaolun
 * @Description: 双端链表(包含首尾端两个引用)
 * @date 2018-11-19 17:37:24
 **/
@ToString
@Getter
public class DoubleEndList {
    private Link first;
    private Link last;

    public DoubleEndList() {
        first = null;
        last = null;
    }

    public void insertFirst(Link link) {//插入到链表的前端
        if (first == null) {//只有一个元素时,首尾元素相同
            last = link;
        }
        link.setNext(first);
        first = link;
    }

    public void insertLast(Link link) {//插入到链表的尾端
        if (first == null) {//只有一个元素时,首尾元素相同
            first = link;
        } else {
            last.setNext(link);
        }
        last = link;
    }


    public void showLink() {//遍历链表
        Link cur = first;
        while (cur != null) {
            cur.showLinkInfo();
            cur = cur.getNext();
        }

    }

    public Link queryLink(String id) {//查找指定的链表元素
        Link cur = first;
        while (cur != null) {
            if (cur.getId().equals(id)) {
                return cur;
            }
            cur = cur.getNext();
        }
        return null;
    }

    public static void main(String a[]) {
        DoubleEndList linkList = new DoubleEndList();

        Link link = new Link();
        link.setId("1");
        link.setName("我是第一个");
        linkList.insertFirst(link);

        Link link1 = new Link();
        link1.setId("2");
        link1.setName("我是第二个");
        linkList.insertFirst(link1);

        Link link2 = new Link();
        link2.setId("3");
        link2.setName("我是第三个");
        linkList.insertFirst(link2);

        System.out.println(linkList.getFirst());
        System.out.println(linkList.getLast());

    }

}

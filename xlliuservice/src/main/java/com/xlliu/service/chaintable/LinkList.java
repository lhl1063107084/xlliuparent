package com.xlliu.service.chaintable;

import lombok.Getter;
import lombok.ToString;

/**
 * @author liuxiaolun
 * @Description: 单向链表操作类
 * @date 2018-11-19 15:41:25
 **/
@ToString
@Getter
public class LinkList {
    private Link first;//链表的头节点

    public LinkList() {
        first = null;
    }

    public void insertLink(Link link) {//插入链表 原先:A(第一个位置)   后来来了B执行操作:B.next= A,A = B (保证新进来的都在第一个位置);
        link.setNext(first);
        first = link;
    }

    public Link deletedLink(String id) {//删除链表
        Link cur = first;
        Link deletedLink = null; //要删除的元素
        Link beforeLink = null; //要删除的元素前一个元素
        while (cur != null) {
            if (cur.getId().equals(id)) {
                if (beforeLink == null) { //符合条件的元素前一个元素为null 证明是首元素,需要为首元素重新赋值
                    first = cur.getNext();
                } else {//执行删除操作
                    beforeLink.setNext(cur.getNext());
                }
                deletedLink = cur;
                break;
            } else {//执行下一次循环
                beforeLink = cur;
                cur = cur.getNext();
                //当前元素作为下一次循环元素的前一个元素
            }
        }

        return deletedLink;
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
        LinkList linkList = new LinkList();

        Link link = new Link();
        link.setId("1");
        link.setName("我是第一个");
        linkList.insertLink(link);

        Link link1 = new Link();
        link1.setId("2");
        link1.setName("我是第二个");
        linkList.insertLink(link1);

        Link link2 = new Link();
        link2.setId("3");
        link2.setName("我是第三个");
        linkList.insertLink(link2);

        System.out.println("删除之前:");
        linkList.showLink();
        System.out.println(linkList.deletedLink("2"));
        System.out.println("删除之后:");
        linkList.showLink();

        System.out.println("查询id为1的元素信息结果:"+linkList.queryLink("1"));

    }

}

package com.xlliu.service.chaintable;

import lombok.Getter;
import lombok.ToString;

/**
 * @author liuxiaolun
 * @Description: 双向链表操作类
 * @date 2018-11-20 16:49:56
 **/
@ToString
@Getter
public class DoubleLyLinkList {
    private LinkLy first;
    private LinkLy last;

    public DoubleLyLinkList() {
        first = null;
        last = null;
    }

    //插入链表的前端
    public void insertLinkLyFirst(LinkLy link) {
        if (first == null) {
            last = link;
            first = link;
        } else {
            link.setNext(first);
            first.setPrevious(link);
            first = link;
        }
    }

    //插入链表的末端
    public void insertLinkLyLast(LinkLy link) {
        if (first == null) {
            last = link;
            first = link;
        } else {
            last.setNext(link);
            link.setPrevious(last);
            last = link;
        }
    }

    public LinkLy deleteLinkLy(String id) {
        //找到要删除的元素
        LinkLy cur = first;
        LinkLy deleteLinkLy = null;

        while (cur != null) {
            if (cur.getId().equals(id)) {//执行删除操作
                if (cur.getPrevious() == null) { //删除第一个元素,重新给第一个元素赋值,并清除尾端的引用
                    first = cur.getNext();
                    LinkLy next = cur.getNext();
                    if (next == null) {//前一个元素、后一个元素都为空证明只有一个元素
                        first = null;
                        last = null;
                    }
                } else if (cur.getNext() == null) { //删除最后一个元素,重新给最后一个元素赋值,并清除首端的引用
                    last = cur.getPrevious();
                    cur.getPrevious().setNext(null);//只有一个元素的情况上面已经判断了,此处不用判断
                } else {
                    //删除
                    cur.getPrevious().setNext(cur.getNext());
                    cur.getNext().setPrevious(cur.getPrevious());
                }
                deleteLinkLy = cur;
                break;
            } else {
                cur = cur.getNext();
            }
        }
        return deleteLinkLy;
    }

    public void showLinkFirst() {//从首端开始遍历
        LinkLy cur = first;
        while (cur != null) {
            cur.showLinkInfo();
            cur = cur.getNext();
        }

    }

    public void showLinkLast() {//从末端开始遍历
        LinkLy cur = last;
        while (cur != null) {
            cur.showLinkInfo();
            cur = cur.getPrevious();
        }

    }

    public static void main(String a[]) {
        DoubleLyLinkList linkList = new DoubleLyLinkList();

        LinkLy link = new LinkLy();
        link.setId("1");
        link.setName("我是第一个");
        linkList.insertLinkLyLast(link);

//        LinkLy link1 = new LinkLy();
//        link1.setId("2");
//        link1.setName("我是第二个");
//        linkList.insertLinkLyLast(link1);
//
//        LinkLy link2 = new LinkLy();
//        link2.setId("3");
//        link2.setName("我是第三个");
//        linkList.insertLinkLyLast(link2);

        System.out.println("删除前,正向遍历");
        linkList.showLinkFirst();

        System.out.println("执行删除操作:");
        linkList.deleteLinkLy("1");

        System.out.println("删除后,正向遍历");
        linkList.showLinkFirst();

        System.out.println("删除后,返向遍历");
        linkList.showLinkLast();


    }


}

package com.xlliu.service.chaintable;

import lombok.Getter;
import lombok.ToString;

/**
 * @author liuxiaolun
 * @Description: 有序链表
 * @date 2018-11-19 17:51:22
 **/
@ToString
@Getter
public class SortLinkList {
    private Link first;


    public SortLinkList() {
        first = null;
    }

    public void insertLinkSort(Link link) {//按照主键从小到大排列
        Link beforeLink = null;
        Link cur = first;
        //找出传入link要插入的位置,记录要插入位置的前一个元素(后一个元素能通过.getNext取到)
        while (cur != null) {
            if (link.getId().compareTo(cur.getId()) >= 1 ? true : false) {
                beforeLink = cur;
                cur = cur.getNext();
            } else {
                break;
            }
        }

        if (beforeLink == null) {
            first = link;
        } else {
            beforeLink.setNext(link);
        }
        link.setNext(cur);
    }


    public static void main(String a[]) {
        SortLinkList linkList = new SortLinkList();

        Link link = new Link();
        link.setId("1");
        link.setName("我是第一个");
        linkList.insertLinkSort(link);

        Link link1 = new Link();
        link1.setId("2");
        link1.setName("我是第二个");
        linkList.insertLinkSort(link1);

        Link link2 = new Link();
        link2.setId("4");
        link2.setName("我是第三个");
        linkList.insertLinkSort(link2);

        Link link3 = new Link();
        link3.setId("3");
        link3.setName("我是第四个");
        linkList.insertLinkSort(link3);

        System.out.println("删除之前:");
        System.out.println(linkList);
    }

}

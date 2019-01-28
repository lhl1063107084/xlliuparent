package com.xlliu.service.tree;

import com.xlliu.po.Student;
import lombok.*;

/**
 * @author liuxiaolun
 * @Description: 树节点封装类
 * @date 2018-11-21 15:39:44
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    private Student student;
    private Node leftNode;
    private Node rightNode;


    public void showNode() {
        System.out.println(student);
    }


}

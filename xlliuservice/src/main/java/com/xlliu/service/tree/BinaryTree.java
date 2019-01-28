package com.xlliu.service.tree;

import com.alibaba.fastjson.JSON;
import com.xlliu.po.Student;
import lombok.Getter;
import lombok.ToString;

/**
 * @author liuxiaolun
 * @Description: 二叉树
 * @date 2018-11-21 15:37:12
 **/
@Getter
@ToString
public class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(Node node) {//插入
        if (root == null) {
            root = node;
        } else {
            //找到要插入的位置
            Integer newId = node.getStudent().getId();
            Node cur = root;
            while (true) {
                if (newId < cur.getStudent().getId()) {
                    if (cur.getLeftNode() == null) {
                        cur.setLeftNode(node);
                        break;
                    } else {
                        cur = cur.getLeftNode();
                    }
                } else {
                    if (cur.getRightNode() == null) {
                        cur.setRightNode(node);
                        break;
                    } else {
                        cur = cur.getRightNode();
                    }
                }
            }
        }
    }

    public Node findById(Integer id) {
        Node cur = root;
        while (true) {
            if (cur == null) {
                return null;
            }
            if (id != cur.getStudent().getId()) {
                if (id < cur.getStudent().getId()) {
                    cur = cur.getLeftNode();
                } else {
                    cur = cur.getRightNode();
                }
            } else {
                break;
            }
        }
        return cur;
    }


    //前序遍历
    public void preorder(Node currentRoot) {
        if (currentRoot != null) {
            System.out.print(currentRoot.getStudent().getId() + "\t");
            preorder(currentRoot.getLeftNode());
            preorder(currentRoot.getRightNode());
        }
    }

    //中序遍历，这三种遍历都用了迭代的思想
    public void inorder(Node currentRoot) {
        if (currentRoot != null) {
            inorder(currentRoot.getLeftNode());  //先对当前节点的左子树对进行中序遍历
            System.out.print(currentRoot.getStudent().getId() + "\t"); //然后访问当前节点
            inorder(currentRoot.getRightNode());  //最后对当前节点的右子树对进行中序遍历
        }
    }

    //后续遍历
    public void postorder(Node currentRoot) {
        if (currentRoot != null) {
            postorder(currentRoot.getLeftNode());
            postorder(currentRoot.getRightNode());
            System.out.print(currentRoot.getStudent().getId() + "\t");
        }
    }


    public static void main(String a[]) {
        /**
         *         10
         *     8       12
         *
         *   6   9  11   19
         *
         * 5   7       12
         */


        BinaryTree binaryTree = new BinaryTree();

        Student student = new Student();
        student.setId(10);
        Node node = new Node(student, null, null);
        binaryTree.insert(node);

        Student student1 = new Student();
        student1.setId(8);
        Node node1 = new Node(student1, null, null);
        binaryTree.insert(node1);

        Student student2 = new Student();
        student2.setId(12);
        Node node2 = new Node(student2, null, null);
        binaryTree.insert(node2);

        Student student3 = new Student();
        student3.setId(6);
        Node node3 = new Node(student3, null, null);
        binaryTree.insert(node3);

        Student student4 = new Student();
        student4.setId(9);
        Node node4 = new Node(student4, null, null);
        binaryTree.insert(node4);

        Student student5 = new Student();
        student5.setId(5);
        Node node5 = new Node(student5, null, null);
        binaryTree.insert(node5);

        Student student6 = new Student();
        student6.setId(7);
        Node node6 = new Node(student6, null, null);
        binaryTree.insert(node6);

        Student student7 = new Student();
        student7.setId(11);
        Node node7 = new Node(student7, null, null);
        binaryTree.insert(node7);

        Student student8 = new Student();
        student8.setId(19);
        Node node8 = new Node(student8, null, null);
        binaryTree.insert(node8);

        Student student9 = new Student();
        student9.setId(12);
        Node node9 = new Node(student9, null, null);
        binaryTree.insert(node9);

        System.out.println(binaryTree.root);

        System.out.println("前序遍历-----------");
        binaryTree.preorder(binaryTree.root);
        System.out.println();

        System.out.println("中序遍历-----------");
        binaryTree.inorder(binaryTree.root);
        System.out.println();

        System.out.println("后序遍历-----------");
        binaryTree.postorder(binaryTree.root);
    }
}

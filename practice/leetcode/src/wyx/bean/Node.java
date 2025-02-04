/*
 * @Author: Tungbo
 * @Date: 2021-08-28 17:18:25
 * @LastEditTime: 2024-02-18 17:03:54
 * @LastEditors: Tungbo
 * @Description: leecode: wyx
 */
package practice.leetcode.src.wyx.bean;

import java.util.List;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node prev;
    public Node child;
    public List<Node> children;
    public Object random;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

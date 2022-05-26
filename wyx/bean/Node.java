/*
 * @Author: Tungbo
 * @Date: 2021-08-28 17:18:25
 * @LastEditTime: 2022-05-26 21:58:38
 * @LastEditors: Tungbo
 * @Description: leecode: wyx
 */
package wyx.bean;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node prev;
    public Node child;
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
}

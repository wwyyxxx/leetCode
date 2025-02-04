/*
 * @Author: Tungbo
 * @Date: 2022-07-15 18:55:04
 * @LastEditTime: 2022-07-15 19:09:36
 * @LastEditors: Tungbo
 * @Description: leecode: 四叉树
 */
package practice.leetcode.src.wyx.bean;

public class Node4 {
    public Boolean val;
    public Boolean isLeaf;
    public Node4 topLeft;
    public Node4 topRight;
    public Node4 bottomLeft;
    public Node4 bottomRight;

    public Node4() {}

    public Node4(Boolean _val, Boolean _isLeaf, Node4 _topLeft, Node4 _topRight, Node4 _bottomLeft, Node4 _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}

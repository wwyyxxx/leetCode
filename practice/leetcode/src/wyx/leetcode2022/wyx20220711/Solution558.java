/*
 * @Author: Tungbo
 * @Date: 2022-07-15 18:51:59
 * @LastEditTime: 2022-07-15 19:21:27
 * @LastEditors: Tungbo
 * @Description: leecode: 558. 四叉树交集
 * 
 * 二进制矩阵中的所有元素不是 0 就是 1 。
 * 
 * 给你两个四叉树，quadTree1 和 quadTree2。其中 quadTree1 表示一个 n * n 二进制矩阵，而 quadTree2 表示另一个 n * n 二进制矩阵。
 * 请你返回一个表示 n * n 二进制矩阵的四叉树，它是 quadTree1 和 quadTree2 所表示的两个二进制矩阵进行 按位逻辑或运算 的结果。
 * 注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。
 * 
 * 四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：
 *  val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False；
 *  isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220711;

import practice.leetcode.src.wyx.bean.Node4;

public class Solution558 {
    public Node4 intersect(Node4 quadTree1, Node4 quadTree2) {
        if (quadTree1.isLeaf) {
            if(quadTree1.val) {
                return new Node4(true, true, null, null, null, null);
            }
            return new Node4(quadTree2.val, quadTree2.isLeaf, quadTree2.topLeft, quadTree2.topRight, quadTree2.bottomLeft, quadTree2.bottomRight);
        }
        if(quadTree2.isLeaf) return intersect(quadTree2,quadTree1);
        Node4 o1 = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node4 o2 = intersect(quadTree1.topRight, quadTree2.topRight);
        Node4 o3 = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node4 o4 = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        if(o1.isLeaf && o2.isLeaf && o3.isLeaf && o4.isLeaf && o1.val == o2.val && o1.val == o3.val && o1.val == o4.val) {
            return new Node4(o1.val, true, null, null, null, null);
        }
        return new Node4(false, false, o1, o2, o3, o4);
    }

}

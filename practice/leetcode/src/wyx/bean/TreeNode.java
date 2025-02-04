/*
 * @Author: Tungbo
 * @Date: 2021-08-28 17:19:08
 * @LastEditTime: 2022-05-26 21:58:43
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
package practice.leetcode.src.wyx.bean;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int x) { val = x; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

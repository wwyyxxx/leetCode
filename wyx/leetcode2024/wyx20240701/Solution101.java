/*
 * @Author: Tungbo
 * @Date: 2024-07-04 16:23:54
 * @LastEditTime: 2024-07-04 16:55:24
 * @LastEditors: Tungbo
 * @Description: leecode: 101. 对称二叉树
 */
package wyx.leetcode2024.wyx20240701;

import wyx.bean.TreeNode;

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        
        return root == null || recur(root.left, root.right);
    }

    private boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left == null || right == null) || left.val != right.val) {
            return false;
        }
        return recur(left.left, right.right) && recur(left.right, right.left);
    }
}

package practice.leetcode.src.wyx.leetcode2024.wyx20240701;
/*
 * @Author: Tungbo
 * @Date: 2024-07-04 16:20:22
 * @LastEditTime: 2024-07-05 15:43:37
 * @LastEditors: Tungbo
 * @Description: leecode: 543. 二叉树的直径
 */

import practice.leetcode.src.wyx.bean.TreeNode;

public class Solution543 {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        recurDepth(root);
        return res;
    }

    private int recurDepth(TreeNode root) {
        if(root == null) return 0;
        int l = recurDepth(root.left);
        int r = recurDepth(root.right);
        res = Math.max(l+r, res);
        return Math.max(l, r) + 1;
    }
}

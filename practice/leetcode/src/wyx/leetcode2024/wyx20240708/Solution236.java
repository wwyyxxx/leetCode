/*
 * @Author: Tungbo
 * @Date: 2024-07-11 17:41:00
 * @LastEditTime: 2024-07-11 17:45:51
 * @LastEditors: Tungbo
 * @Description: leecode: 236. 二叉树的最近公共祖先
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240708;

import practice.leetcode.src.wyx.bean.TreeNode;

public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}

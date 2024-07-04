/*
 * @Author: Tungbo
 * @Date: 2024-07-04 16:20:22
 * @LastEditTime: 2024-07-04 16:22:43
 * @LastEditors: Tungbo
 * @Description: leecode: 226. 翻转二叉树
 */
package wyx.leetcode2024.wyx20240701;

import wyx.bean.TreeNode;

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}

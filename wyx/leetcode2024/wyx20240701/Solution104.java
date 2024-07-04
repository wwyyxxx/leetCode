/*
 * @Author: Tungbo
 * @Date: 2024-07-04 15:46:01
 * @LastEditTime: 2024-07-04 16:16:22
 * @LastEditors: Tungbo
 * @Description: leecode: 104. 二叉树的最大深度
 */
package wyx.leetcode2024.wyx20240701;

import wyx.bean.TreeNode;

public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        return Math.max(left, right) + 1;
    }
}

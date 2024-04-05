/*
 * @Author: Tungbo
 * @Date: 2024-04-05 20:59:27
 * @LastEditTime: 2024-04-05 21:06:16
 * @LastEditors: Tungbo
 * @Description: leecode: 1026. 节点与其祖先之间的最大差值
 */
package wyx.leetcode2024.wyx20240401;

import wyx.bean.TreeNode;

public class Solution1026 {
    public int maxAncestorDiff(TreeNode root) {
        int left = dfs(root.left, root.val, root.val);
        int right = dfs(root.right, root.val, root.val);
        return Math.max(left, right);
    }

    private int dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return Math.abs(min - max);
        }
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        return Math.max(dfs(root.left, min, max), dfs(root.right, min, max));
    }
}

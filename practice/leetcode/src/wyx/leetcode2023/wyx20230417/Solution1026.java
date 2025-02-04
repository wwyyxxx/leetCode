package practice.leetcode.src.wyx.leetcode2023.wyx20230417;

import practice.leetcode.src.wyx.bean.TreeNode;

/*
 * @Author: Tungbo
 * @Date: 2023-04-16 11:59:04
 * @LastEditTime: 2023-04-18 12:00:21
 * @LastEditors: Tungbo
 * @Description: leecode: 1157. 子数组中占绝大多数的元素
 */
public class Solution1026 {
    int res = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) return 0;
        dfs(root, root.val, root.val);
        return res;
    }
    private void dfs(TreeNode root, int max, int min) {
        if(root == null) return;
        max = Math.max(max, root.val);
        min = Math.min(root.val, min);
        if(root.left == null && root.right == null) res = Math.max(res, max - min);
        dfs(root.left, max, min);
        dfs(root.right, max, min);
    }
}

/*
 * @Author: Tungbo
 * @Date: 2024-07-12 17:18:15
 * @LastEditTime: 2024-07-12 17:29:04
 * @LastEditors: Tungbo
 * @Description: leecode: 124. 二叉树中的最大路径和
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240708;

import practice.leetcode.src.wyx.bean.TreeNode;

public class Solution124 {

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        dfs(root);

        return ans;
    }

    private int dfs(TreeNode root) {
        int ret = 0;
        if (root == null) {
            return ret;
        }
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right),0);
        
        int temp = root.val + left + right;
        ans = Math.max(ans, temp);
        return root.val + Math.max(left, right);
    }
}

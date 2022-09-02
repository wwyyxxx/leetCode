package wyx.wyx20220829;

import wyx.bean.TreeNode;

/*
 * @Author: Tungbo
 * @Date: 2022-09-02 16:02:40
 * @LastEditTime: 2022-09-02 16:35:05
 * @LastEditors: Tungbo
 * @Description: leecode: 687. 最长同值路径
 * 
 * 给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点
 * 两个节点之间的路径长度 由它们之间的边数表示
 * 
 */
public class Solution687 {

    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int left1 = 0, right1 = 0;
        if (root.left != null && root.left.val == root.val) {
            left1 = left1 + 1 + left;
        }
        if (root.right != null && root.right.val == root.val) {
            right1 = right1 + 1 + right;
        }
        ans = Math.max(ans, right1 + left1);
        return Math.max(left1, right1);
    }

}

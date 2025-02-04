/*
 * @Author: Tungbo
 * @Date: 2024-02-22 15:05:40
 * @LastEditTime: 2024-02-22 16:42:53
 * @LastEditors: Tungbo
 * @Description: leecode: 889. 根据前序和后序遍历构造二叉树
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240218;

import java.util.HashMap;

import practice.leetcode.src.wyx.bean.TreeNode;

public class Solution889 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        int[] index = new int[n + 1];
        for (int i = 0; i < n; i++) {
            index[postorder[i]] = i;
        }
        return dfs(preorder, 0, n, postorder, 0, n, index); // 左闭右开区间
    }

    private TreeNode dfs(int[] preorder, int preL, int preR, int[] postorder, int postL, int postR, int[] index) {
        if (preL == preR) { // 空节点
            return null;
        }
        if (preL + 1 == preR) { // 叶子节点
            return new TreeNode(preorder[preL]);
        }
        int leftSize = index[preorder[preL + 1]] - postL + 1; // 左子树的大小
        TreeNode left = dfs(preorder, preL + 1, preL + 1 + leftSize, postorder, postL, postL + leftSize, index);
        TreeNode right = dfs(preorder, preL + 1 + leftSize, preR, postorder, postL + leftSize, postR - 1, index);
        return new TreeNode(preorder[preL], left, right);
    }
}

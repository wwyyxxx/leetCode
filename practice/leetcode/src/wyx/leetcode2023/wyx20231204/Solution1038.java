/*
 * @Author: Tungbo
 * @Date: 2023-12-04 16:25:37
 * @LastEditTime: 2023-12-04 16:48:03
 * @LastEditors: Tungbo
 * @Description: leecode: 1038. 从二叉搜索树到更大和树
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20231204;

import practice.leetcode.src.wyx.bean.TreeNode;

public class Solution1038 {

    private int s = 0;

    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if(root == null) return;

        dfs(root.right);
        s += root.val;
        root.val = s;

        dfs(root.left);
    }
}

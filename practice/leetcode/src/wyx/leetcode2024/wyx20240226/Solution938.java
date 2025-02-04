/*
 * @Author: Tungbo
 * @Date: 2024-02-26 14:11:10
 * @LastEditTime: 2024-02-26 14:11:12
 * @LastEditors: Tungbo
 * @Description: leecode: 938. 二叉搜索树的范围和
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240226;

import practice.leetcode.src.wyx.bean.TreeNode;

public class Solution938 {
    int low,high,res;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;
        dfs(root.left);
        dfs(root.right);
        if(root.val >= low && root.val <= high) {
            res += root.val;
        }
        return res;
    }
}

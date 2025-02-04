/*
 * @Author: Tungbo
 * @Date: 2024-07-06 15:48:42
 * @LastEditTime: 2024-07-06 16:04:29
 * @LastEditors: Tungbo
 * @Description: leecode: 108. 将有序数组转换为二叉搜索树
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240701;

import practice.leetcode.src.wyx.bean.TreeNode;

public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l ) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums, l, mid-1);
        node.right = dfs(nums, mid - 1, r);
        return node;
    }
}

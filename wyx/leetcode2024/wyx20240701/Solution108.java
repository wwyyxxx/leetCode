/*
 * @Author: Tungbo
 * @Date: 2024-07-06 15:48:42
 * @LastEditTime: 2024-07-06 15:55:22
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
package wyx.leetcode2024.wyx20240701;

import wyx.bean.TreeNode;

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

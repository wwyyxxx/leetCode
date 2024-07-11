/*
 * @Author: Tungbo
 * @Date: 2024-07-11 16:14:12
 * @LastEditTime: 2024-07-11 16:20:44
 * @LastEditors: Tungbo
 * @Description: leecode: 437. 路径总和 III
 */
package wyx.leetcode2024.wyx20240708;

import wyx.bean.TreeNode;

public class Solution437 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        ret += rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    private int rootSum(TreeNode root, long targetSum) {
        int ret = 0;
        if (root == null) {
            return ret;
        }

        int val = root.val;
        if (val == targetSum) {
            ret++;
        }

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }
}

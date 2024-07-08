/*
 * @Author: Tungbo
 * @Date: 2024-07-06 16:06:26
 * @LastEditTime: 2024-07-06 16:31:48
 * @LastEditors: Tungbo
 * @Description: leecode: 98. 验证二叉搜索树
 */
package wyx.leetcode2024.wyx20240701;

import wyx.bean.TreeNode;

public class Solutio98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}

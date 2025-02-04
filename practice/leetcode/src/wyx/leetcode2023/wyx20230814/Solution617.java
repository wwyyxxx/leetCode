/*
 * @Author: Tungbo
 * @Date: 2023-08-14 17:42:30
 * @LastEditTime: 2023-08-14 17:42:32
 * @LastEditors: Tungbo
 * @Description: leecode: 617. 合并二叉树
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230814;

import practice.leetcode.src.wyx.bean.TreeNode;

public class Solution617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }
}

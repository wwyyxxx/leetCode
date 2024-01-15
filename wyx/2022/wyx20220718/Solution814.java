/*
 * @Author: Tungbo
 * @Date: 2022-07-21 18:43:36
 * @LastEditTime: 2022-07-21 18:52:38
 * @LastEditors: Tungbo
 * @Description: leecode: 814. 二叉树剪枝
 * 
 * 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1
 * 返回移除了所有不包含 1 的子树的原二叉树
 * 节点 node 的子树为 node 本身加上所有 node 的后代
 * 
 */
package wyx.wyx20220718;

import wyx.bean.TreeNode;

public class Solution814 {
    public TreeNode pruneTree(TreeNode root) {
        return dfsPrune(root);
    }

    private TreeNode dfsPrune(TreeNode root) {
        if(root == null) return null;
        root.left = dfsPrune(root.left);
        root.right = dfsPrune(root.right);
        if(root.right == null && root.left == null && root.val == 0) return null;
        return root;
    }
}

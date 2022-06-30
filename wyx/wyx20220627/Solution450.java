/*
 * @Author: Tungbo
 * @Date: 2022-06-30 16:22:16
 * @LastEditTime: 2022-06-30 16:51:59
 * @LastEditors: Tungbo
 * @Description: leecode: 450. 删除二叉搜索树中的节点
 * 
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 *  首先找到需要删除的节点；
 *  如果找到了，删除它。
 * 
 */
package wyx.wyx20220627;

import wyx.bean.TreeNode;

public class Solution450 {
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if(root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if(root.val == key) {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode child = root.right;
            while(child.left != null) child = child.left;
            root.right = deleteNode(root.right, child.val);
            child.left = root.left;
            child.right = root.right;
            return child;
        }
        return root;
    }
    
}

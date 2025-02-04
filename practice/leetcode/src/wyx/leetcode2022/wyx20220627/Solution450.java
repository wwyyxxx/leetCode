/*
 * @Author: Tungbo
 * @Date: 2022-06-30 16:22:16
 * @LastEditTime: 2022-06-30 17:01:32
 * @LastEditors: Tungbo
 * @Description: leecode: 450. 删除二叉搜索树中的节点
 * 
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 *  首先找到需要删除的节点；
 *  如果找到了，删除它。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220627;

import practice.leetcode.src.wyx.bean.TreeNode;

public class Solution450 {
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val > key) {
            //需要删除的节点在左边
            root.left = deleteNode(root.left, key);
            return root;
        }
        if(root.val < key) {
            //需要删除的节点在右边
            root.right = deleteNode(root.right, key);
            return root;
        }
        if(root.val == key) {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode child = root.right;
            while(child.left != null) child = child.left; //找到需要删除节点的右子节点 的 最左子节点。把左子节点赋值过去
            root.right = deleteNode(root.right, child.val);
            child.left = root.left; // 将欲删除节点的左子树成为其右子树的最左节点的左子树
            child.right = root.right; // 欲删除节点的右子顶替其位置，节点被删除
            return child;
        }
        return root;
    }
    
}

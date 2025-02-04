package practice.leetcode.src.wyx.leetcode2022.wyx20220725;

import java.util.LinkedList;

import practice.leetcode.src.wyx.bean.TreeNode;

/*
 * @Author: Tungbo
 * @Date: 2022-07-25 15:12:36
 * @LastEditTime: 2022-07-25 16:03:14
 * @LastEditors: Tungbo
 * @Description: leecode: 919. 完全二叉树插入器
 * 
 * 完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 * 
 * 
 * 
 */
public class CBTInserter {

    TreeNode root;
    LinkedList<TreeNode> candidate;

    // 使用头节点为 root 的给定树初始化该数据结构
    public CBTInserter(TreeNode root) {
        this.root = root;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        candidate = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode child = queue.poll();
            if (child.left != null)
                queue.offer(child.left);
            if (child.right != null)
                queue.offer(child.right);
            if (!(child.left != null && child.right != null))
                candidate.offer(child);
        }
    }

    // 向树中插入一个值为 Node.val == val的新节点 TreeNode。使树保持完全二叉树的状态，并返回插入节点 TreeNode 的父节点的值
    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode node = candidate.peek();
        if (node.left == null)
            node.left = child;
        else {
            node.right = child;
            candidate.poll();
            candidate.offer(child);
        }
        return node.val;
    }

    // 将返回树的头节点
    public TreeNode get_root() {
        return root;
    }
}

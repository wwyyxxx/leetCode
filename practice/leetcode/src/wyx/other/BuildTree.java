package practice.leetcode.src.wyx.other;

import java.util.HashMap;

import practice.leetcode.src.wyx.bean.TreeNode;

/*
 * @Author: Tungbo
 * @Date: 2021-06-29 16:05:18
 * @LastEditTime: 2022-05-26 21:57:39
 * @LastEditors: Tungbo
 * @Description: leecode: 重建二叉树
 */
public class BuildTree {
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int root, int left, int right) {
        if(left > right) return null;                          // 递归终止
        TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }
}
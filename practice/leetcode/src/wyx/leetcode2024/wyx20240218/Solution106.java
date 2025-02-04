package practice.leetcode.src.wyx.leetcode2024.wyx20240218;

import java.util.HashMap;

import practice.leetcode.src.wyx.bean.TreeNode;
import practice.leetcode.src.wyx.other.printNumbers;

/*
 * @Author: Tungbo
 * @Date: 2024-02-21 10:51:45
 * @LastEditTime: 2024-02-21 14:48:21
 * @LastEditors: Tungbo
 * @Description: leecode: 106. 从中序与后序遍历序列构造二叉树
 */
public class Solution106 {
    int[] postorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recurr(postorder.length -1, 0, postorder.length -1);
    }

    private TreeNode recurr(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[root]);
        int i = dic.get(postorder[root]);
        node.right = recurr(root - 1, i + 1, right);
        node.left = recurr(root - 1 - (right - i), left, i - 1);
        return node;
    }
}

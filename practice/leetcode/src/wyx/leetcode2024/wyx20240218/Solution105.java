/*
 * @Author: Tungbo
 * @Date: 2024-02-20 10:51:45
 * @LastEditTime: 2024-02-20 11:38:47
 * @LastEditors: Tungbo
 * @Description: leecode: 105. 从前序与中序遍历序列构造二叉树
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240218;

import java.util.HashMap;
import java.util.Map;

import practice.leetcode.src.wyx.bean.TreeNode;

public class Solution105 {
    Map<Integer, Integer> dic = new HashMap<>();
    int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recurr(0, 0, preorder.length - 1);
    }

    private TreeNode recurr(int root, int left, int right){
        if(left > right) return null;
        int i = dic.get(preorder[root]);//分割点
        TreeNode node = new TreeNode(preorder[root]);
        node.left = recurr(root + 1, left, i -1);
        node.right = recurr(root + 1 + i - left, i + 1, right); // 开启右子树递归
        return node;
    }
}

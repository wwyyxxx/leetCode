/*
 * @Author: Tungbo
 * @Date: 2024-07-10 17:41:42
 * @LastEditTime: 2024-07-10 18:00:51
 * @LastEditors: Tungbo
 * @Description: leecode: 105. 从前序与中序遍历序列构造二叉树
 */
package wyx.leetcode2024.wyx20240708;

import java.util.Map;

import wyx.bean.TreeNode;

public class Solution105 {

    Map<Integer, Integer> dic;
    int[] preorder;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recurr(0, 0, preorder.length - 1);
    }
    //preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    private TreeNode recurr(int root, int l, int r) {
        if (l > r) {
            return null;
        }
        int i = dic.get(preorder[root]);
        TreeNode node = new TreeNode(preorder[root]);
        node.left = recurr(root+1, l, i - 1);
        node.right = recurr(root + i - l + 1, i + 1, r);
        return node;
    }
}

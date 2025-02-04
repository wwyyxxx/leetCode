/*
 * @Author: Tungbo
 * @Date: 2024-07-04 15:39:47
 * @LastEditTime: 2024-07-04 15:45:30
 * @LastEditors: Tungbo
 * @Description: leecode: 94. 二叉树的中序遍历
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240701;

import java.util.ArrayList;
import java.util.List;

import practice.leetcode.src.wyx.bean.TreeNode;

public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root,res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if(root == null) return;
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }
}

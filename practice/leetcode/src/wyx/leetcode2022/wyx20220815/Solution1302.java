/*
 * @Author: Tungbo
 * @Date: 2022-08-17 17:10:18
 * @LastEditTime: 2022-08-17 17:24:43
 * @LastEditors: Tungbo
 * @Description: leecode: 1302. 层数最深叶子节点的和
 * 
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220815;

import java.util.LinkedList;

import practice.leetcode.src.wyx.bean.TreeNode;

public class Solution1302 {
    
    public int deepestLeavesSum(TreeNode root) {
        int ans = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        while(!queue.isEmpty()) {
            int temp = 0;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                temp += node.val;
                if(node.left != null) { queue.addLast(node.left); }
                if(node.right != null) { queue.addLast(node.right); }
            }
            ans = temp;
        }
        return ans;
    }

}

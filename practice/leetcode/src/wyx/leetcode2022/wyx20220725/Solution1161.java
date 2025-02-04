/*
 * @Author: Tungbo
 * @Date: 2022-07-31 22:00:55
 * @LastEditTime: 2022-07-31 22:20:25
 * @LastEditors: Tungbo
 * @Description: leecode: 1161. 最大层内元素和
 * 
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220725;

import java.util.LinkedList;

import practice.leetcode.src.wyx.bean.TreeNode;

public class Solution1161 {

    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int maxLine = 1;
        int maxCount = Integer.MIN_VALUE;
        int currLine = 1;
        while (!queue.isEmpty()) {
            int sum = 0;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            if(maxCount < sum) {
                maxLine = currLine;
                maxCount = sum;
            }
            currLine++;
        }
        return maxLine;
    }

}

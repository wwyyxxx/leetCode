/*
 * @Author: Tungbo
 * @Date: 2024-07-05 15:44:32
 * @LastEditTime: 2024-07-05 15:52:50
 * @LastEditors: Tungbo
 * @Description: leecode: 102. 二叉树的层序遍历
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240701;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import practice.leetcode.src.wyx.bean.TreeNode;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                tempList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tempList);
        }
        return res;
    }
}

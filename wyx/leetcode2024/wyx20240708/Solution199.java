/*
 * @Author: Tungbo
 * @Date: 2024-07-08 19:22:59
 * @LastEditTime: 2024-07-08 19:32:16
 * @LastEditors: Tungbo
 * @Description: leecode: 199. 二叉树的右视图
 */
package wyx.leetcode2024.wyx20240708;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import wyx.bean.TreeNode;

public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (i == n - 1) {
                    res.add(node.val);
                }
                
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}

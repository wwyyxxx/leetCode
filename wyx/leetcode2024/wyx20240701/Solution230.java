/*
 * @Author: Tungbo
 * @Date: 2024-07-07 15:41:48
 * @LastEditTime: 2024-07-07 15:53:55
 * @LastEditors: Tungbo
 * @Description: leecode: 230. 二叉搜索树中第K小的元素
 */
package wyx.leetcode2024.wyx20240701;

import java.util.PriorityQueue;

import wyx.bean.TreeNode;

public class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        dfs(queue, root);
        
        for(int i = 1; i < k; i++) {
            queue.poll();
        }
        return queue.poll();
    }

    private void dfs(PriorityQueue<Integer> queue, TreeNode root) {
        if (root == null) {
            return;
        }
        queue.add(root.val);
        dfs(queue, root.left);
        dfs(queue, root.right);
    }
}

/*
 * @Author: Tungbo
 * @Date: 2024-02-23 10:23:55
 * @LastEditTime: 2024-02-23 10:46:50
 * @LastEditors: Tungbo
 * @Description: leecode: 2583. 二叉树中的第 K 大层和
 */
package wyx.leetcode2024.wyx20240218;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javafx.util.Pair;
import wyx.bean.TreeNode;

public class Solution2583 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                sum += node.val;
            }
            list.add(sum);
        }
        if (k > list.size()) {
            return -1;
        }
        Collections.sort(list);
        return list.get(list.size() - k);
    }
}

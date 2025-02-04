/*
 * @Author: Tungbo
 * @Date: 2024-04-24 16:35:31
 * @LastEditTime: 2024-04-24 17:29:32
 * @LastEditors: Tungbo
 * @Description: leecode: 2385. 感染二叉树需要的总时间
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240422;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import practice.leetcode.src.wyx.bean.TreeNode;

public class Solution2385 {
    private TreeNode startNode;
    private final Map<TreeNode, TreeNode> fa = new HashMap<>();

    public int amountOfTime(TreeNode root, int start) {
        dfs(root, null, start);
        return maxDepth(startNode, startNode);
    }

    private void dfs(TreeNode node, TreeNode from, int start) {
        if (node == null) {
            return;
        }
        fa.put(node, from); // 记录每个节点的父节点
        if (node.val == start) {
            startNode = node; // 找到 start
        }
        dfs(node.left, node, start);
        dfs(node.right, node, start);
    }

    private int maxDepth(TreeNode node, TreeNode from) {
        if (node == null) {
            return -1; // 注意这里是 -1，因为 start 的深度为 0
        }
        int res = -1;
        if (node.left != from) {
            res = Math.max(res, maxDepth(node.left, node));
        }
        if (node.right != from) {
            res = Math.max(res, maxDepth(node.right, node));
        }
        if (fa.get(node) != from) {
            res = Math.max(res, maxDepth(fa.get(node), node));
        }
        return res + 1;
    }
    
}

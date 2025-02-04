/*
 * @Author: Tungbo
 * @Date: 2022-06-19 21:28:17
 * @LastEditTime: 2022-06-19 21:40:14
 * @LastEditors: Tungbo
 * @Description: leecode: 508. 出现次数最多的子树元素和
 * 
 * 给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 * 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220613;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import practice.leetcode.src.wyx.bean.TreeNode;

public class Solution508 {
    HashMap<Integer, Integer> map = new HashMap<>();
    int max;
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> ans = new ArrayList<>();
        for (Integer i : map.keySet()) {
            if (map.get(i) == max) {
                ans.add(i);
            }
        }

        int[] res = new int[ans.size()];
        int idx = 0;
        for (int i : ans) {
            res[idx++] = i;
        }
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int curr = root.val + dfs(root.left) + dfs(root.right);
        map.put(curr, map.getOrDefault(curr,0) + 1);
        max = Math.max(map.get(curr), max);
        return curr;
    }
    
}

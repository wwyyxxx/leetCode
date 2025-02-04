/*
 * @Author: Tungbo
 * @Date: 2024-02-19 14:14:14
 * @LastEditTime: 2024-02-19 14:30:53
 * @LastEditors: Tungbo
 * @Description: leecode: 590. N 叉树的后序遍历
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240218;

import java.util.ArrayList;
import java.util.List;

import practice.leetcode.src.wyx.bean.Node;

public class Solution590 {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    private void dfs(List<Integer> res, Node root) {
        if (root == null) {
            return;
        }
        for(Node node : root.children) {
            dfs(res, node);
        }
        res.add(root.val);
    }
}

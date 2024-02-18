/*
 * @Author: Tungbo
 * @Date: 2024-02-18 16:55:16
 * @LastEditTime: 2024-02-18 17:00:32
 * @LastEditors: Tungbo
 * @Description: leecode: 589. N 叉树的前序遍历
 */
package wyx.leetcode2024.wyx20240218;

import java.util.ArrayList;
import java.util.List;

import wyx.bean.Node;

public class Solution589 {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        for(Node node : root.children) {
            dfs(node, list);
        }
    }
}

/*
 * @Author: Tungbo
 * @Date: 2024-07-08 20:00:12
 * @LastEditTime: 2024-07-08 20:00:15
 * @LastEditors: Tungbo
 * @Description: leecode: 114. 二叉树展开为链表
 */
package wyx.leetcode2024.wyx20240708;

import java.util.ArrayList;
import java.util.List;

import wyx.bean.TreeNode;

public class Soluton114 {
    public void flatten(TreeNode root) {
        if(root == null) return;
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        for(int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    private void dfs(TreeNode root, List<TreeNode> list) {
        if(root == null) return;
        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}

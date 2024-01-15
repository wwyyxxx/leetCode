/*
 * @Author: Tungbot
 * @Date: 2023-02-06 14:20:55
 * @LastEditTime: 2023-02-06 14:46:20
 * @LastEditors: Tungbo
 * @Description: leecode: 2331. 计算布尔二叉树的值
 */
package wyx.wyx20230206;

import wyx.bean.TreeNode;

public class Solution23311 {
    public boolean evaluateTree(TreeNode root) {
        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        if(root.val == 0 || root.val == 1) return root.val == 1 ? true : false;
        int flag = root.val;
        boolean l = dfs(root.left);
        boolean r = dfs(root.right);
        return flag == 2 ? l || r : l && r;
    }
}

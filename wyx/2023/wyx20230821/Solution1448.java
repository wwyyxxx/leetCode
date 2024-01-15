/*
 * @Author: Tungbo
 * @Date: 2023-08-25 17:28:05
 * @LastEditTime: 2023-08-25 17:37:32
 * @LastEditors: Tungbo
 * @Description: leecode: 1448. 统计二叉树中好节点的数目
 */
package wyx.wyx20230821;

import wyx.bean.TreeNode;

public class Solution1448 {
    int ans = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return ans;
    }

    private void dfs(TreeNode root, int max) {
        if(root== null) return;
        if(root.val >= max) {
           ans++; 
           max = root.val;
        }
        dfs(root.left, max);
        dfs(root.right, max);
    }
}

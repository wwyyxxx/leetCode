/*
 * @Author: Tungbo
 * @Date: 2023-02-03 13:01:05
 * @LastEditTime: 2023-02-03 13:11:55
 * @LastEditors: Tungbo
 * @Description: leecode: 1145. 二叉树着色游戏
 */
package wyx.wyx20230130;

import wyx.bean.TreeNode;

public class Solution1145 {
    int ls,rs,x;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        this.x = x;
        dfs(root);
        return n < 2*Math.max(ls,Math.max(rs, n -ls - rs -1));
    }
    private int dfs(TreeNode root) {
        if(root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        if(root.val == x) {
            ls = l;
            rs = r;
        }
        return l + r + 1;
    }
}

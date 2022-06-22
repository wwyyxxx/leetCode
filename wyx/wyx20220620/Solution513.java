/*
 * @Author: Tungbo
 * @Date: 2022-06-22 11:20:30
 * @LastEditTime: 2022-06-22 11:20:32
 * @LastEditors: Tungbo
 * @Description: leecode: 513. 找树左下角的值
 * 
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 * 
 */
package wyx.wyx20220620;

import javax.swing.tree.TreeNode;

public class Solution513 {

    int maxLeft;
    int maxHeight =0;
    public int findBottomLeftValue(TreeNode root) {
        int currHeight =0;
        dfs(root,currHeight);
        return maxLeft;
    }

    public void dfs(TreeNode root,int currHeight) {
        if(root == null) return;
        currHeight++;
        dfs(root.left,currHeight);
        dfs(root.right,currHeight);
        if(currHeight > maxHeight) {
            maxHeight = currHeight;
            maxLeft = root.val;
        }
    }
    
}

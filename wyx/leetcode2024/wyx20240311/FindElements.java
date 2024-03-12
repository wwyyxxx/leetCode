/*
 * @Author: Tungbo
 * @Date: 2024-03-12 15:07:38
 * @LastEditTime: 2024-03-12 15:22:15
 * @LastEditors: Tungbo
 * @Description: leecode: 1261. 在受污染的二叉树中查找元素
 */
package wyx.leetcode2024.wyx20240311;

import java.util.HashSet;
import java.util.Set;

import wyx.bean.TreeNode;

public class FindElements {
    Set<Integer> dic = new HashSet<>();
    public FindElements(TreeNode root) {
        
        dfs(root, 0);
    }
    
    private void dfs(TreeNode root, int i) {
        if(root == null) return;
        root.val = i;
        dic.add(i);
        dfs(root.left, 2*i+1);
        dfs(root.right, 2*i+2);
    }

    public boolean find(int target) {
        return dic.contains(target);
    }
}

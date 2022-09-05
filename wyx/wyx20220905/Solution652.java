/*
 * @Author: Tungbo
 * @Date: 2022-09-05 14:38:51
 * @LastEditTime: 2022-09-05 14:48:11
 * @LastEditors: Tungbo
 * @Description: leecode: 652. 寻找重复的子树
 * 
 * 给定一棵二叉树 root，返回所有重复的子树
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的
 * 
 */
package wyx.wyx20220905;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import wyx.bean.TreeNode;

public class Solution652 {

    HashMap<String, Integer> map = new HashMap<String, Integer>();
    List<TreeNode> list = new ArrayList<TreeNode>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return list;
    }

    private String dfs(TreeNode root) {
        if (root == null)
            return " ";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append("-");
        sb.append(dfs(root.left)).append(dfs(root.right));
        String str = sb.toString();
        map.put(str, map.getOrDefault(str, 0) + 1);
        if (map.get(str) == 2)
            list.add(root);
        return str;
    }

}

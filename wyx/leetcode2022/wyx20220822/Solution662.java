/*
 * @Author: Tungbo
 * @Date: 2022-08-27 16:01:31
 * @LastEditTime: 2022-08-27 16:52:01
 * @LastEditors: Tungbo
 * @Description: leecode: 662. 二叉树最大宽度
 * 
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度
 * 树的 最大宽度 是所有层中最大的 宽度
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度
 * 题目数据保证答案将会在  32 位 带符号整数范围内
 * 
 */
package wyx.wyx20220822;

import java.util.ArrayList;
import java.util.List;

import wyx.bean.Pair;
import wyx.bean.TreeNode;

public class Solution662 {

    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        if (root == null)
            return ans;
        List<Pair<TreeNode, Integer>> list = new ArrayList<Pair<TreeNode, Integer>>();
        list.add(new Pair<TreeNode, Integer>(root, 1));
        while (!list.isEmpty()) {
            List<Pair<TreeNode, Integer>> temp = new ArrayList<Pair<TreeNode, Integer>>();
            for (Pair<TreeNode, Integer> pair : list) {
                TreeNode node = pair.getKey();
                int index = pair.getValue();
                if (node.left != null)
                    temp.add(new Pair<TreeNode, Integer>(node.left, 2 * index));
                if (node.right != null)
                    temp.add(new Pair<TreeNode, Integer>(node.right, 2 * index + 1));
            }
            ans = Math.max(ans, list.get(list.size() - 1).getValue() - list.get(0).getValue() + 1);
            list = temp;
        }
        return ans;
    }
}

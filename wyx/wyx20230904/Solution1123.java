/*
 * @Author: Tungbo
 * @Date: 2023-09-06 19:26:12
 * @LastEditTime: 2023-09-06 19:34:47
 * @LastEditors: Tungbo
 * @Description: leecode: 1123. 最深叶节点的最近公共祖先
 */
package wyx.wyx20230904;

import wyx.bean.Pair;
import wyx.bean.TreeNode;

public class Solution1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return f(root).getKey();
    }

    private Pair<TreeNode, Integer> f(TreeNode root) {
        if(root == null) {
            return new Pair<>(root, 0);
        }
        Pair<TreeNode, Integer> left = f(root.left);
        Pair<TreeNode, Integer> right = f(root.right);
        if(left.getValue() > right.getValue()) {
            return new Pair<TreeNode,Integer>(left.getKey(), left.getValue()+1);
        }
        if(left.getValue() < right.getValue()) {
            return new Pair<TreeNode,Integer>(right.getKey(), right.getValue()+1);
        }
        return new Pair<TreeNode,Integer>(root, left.getValue()+1);
    }
}

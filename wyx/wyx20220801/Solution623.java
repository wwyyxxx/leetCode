/*
 * @Author: Tungbo
 * @Date: 2022-08-05 11:03:13
 * @LastEditTime: 2022-08-05 11:35:10
 * @LastEditors: Tungbo
 * @Description: leecode: 623. 在二叉树中增加一行
 * 
 * 给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行
 * 注意，根节点 root 位于深度 1
 * 
 */
package wyx.wyx20220801;

import java.util.LinkedList;

import wyx.bean.TreeNode;

public class Solution623 {
    
    public TreeNode addOneRow1(TreeNode root, int val, int depth) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currDepth = 0;
        if(depth == 1) {
            return new TreeNode(val,root,null);
        }
        while (!queue.isEmpty()) {
            currDepth++;
            if(currDepth == depth - 1) {
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    TreeNode child = queue.poll();
                    TreeNode nodeLeft = new TreeNode(val);
                    TreeNode nodeRith = new TreeNode(val);
                    if(child.left != null) nodeLeft.left = child.left;
                    if(child.right != null) nodeRith.right = child.right;
                    child.left = nodeLeft;
                    child.right = nodeRith;
                }
                break;
            }
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode child = queue.poll();
                if(child.left != null) queue.add(child.left);
                if(child.right != null) queue.add(child.right);
            }
        }
        return root;
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root == null) return null;
        if(depth == 1) return new TreeNode(val,root,null);
        if(depth == 2) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        } else {
            root.left = addOneRow(root.left, val, depth - 1);
            root.right = addOneRow(root.right, val, depth - 1);
        }
        return root;
    }

}

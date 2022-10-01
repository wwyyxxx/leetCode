package wyx.other;

import wyx.bean.*;

/*
 * @Author: Tungbo
 * @Date: 2020-10-10 13:45:13
 * @LastEditTime: 2022-05-26 21:56:21
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
public class reverseTree{
    public static void main(String[] args) {
        System.out.println("Test");
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode right = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(right);
        return root;
    }
}
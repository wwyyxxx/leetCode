package wyx.wyx20220523;

import wyx.bean.TreeNode;
import java.util.Stack;

/*
 * @Author: Tungbo
 * @Date: 2022-05-23 17:02:36
 * @LastEditTime: 2022-05-26 21:57:51
 * @LastEditors: Tungbo
 * @Description: leecode: 114. 二叉树展开为链表
 * 
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * 
 */
public class Solution114 {

    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode pre = null;

        //利用栈的先进后出 先序遍历
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            
            if(pre != null) {
                //改变上一个节点的指针的
                pre.left = null;
                pre.right = temp;
            }

            //先进后出，每次弹出一个，所以先把右节点压入栈中
            TreeNode left = temp.left, right = temp.right;
            if(right!=null) {
                stack.add(right);
            }
            if(left!=null) {
                stack.add(left);
            }
            
            // 保存上一个节点
            pre = temp; 
        }
    }
}

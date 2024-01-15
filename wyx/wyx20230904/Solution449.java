/*
 * @Author: Tungbo
 * @Date: 2023-09-04 22:18:23
 * @LastEditTime: 2023-09-04 23:11:20
 * @LastEditors: Tungbo
 * @Description: leecode: 449. 序列化和反序列化二叉搜索树
 */
package wyx.wyx20230904;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import wyx.bean.TreeNode;

public class Solution449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        postOrder(root, list);
        String str = list.toString();
        return str.substring(1, str.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] list = data.split(", ");
        Stack<Integer> stack = new Stack<>();
        for(String s : list) {
            stack.push(Integer.parseInt(s));
        }
        return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
    }

    private void postOrder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

     private TreeNode construct(int lower, int upper, Stack<Integer> stack) {
        if(stack.isEmpty() || stack.peek() < lower || stack.peek() > upper) return null;

        int val = stack.pop();
        TreeNode root = new TreeNode(val);
        root.right = construct(val, upper, stack);
        root.left = construct(lower, val, stack);
        return root;
     }
}

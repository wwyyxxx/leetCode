/*
 * @Author: Tungbo
 * @Date: 2024-03-31 16:51:48
 * @LastEditTime: 2024-03-31 17:08:32
 * @LastEditors: Tungbo
 * @Description: leecode: 331. 验证二叉树的前序序列化
 */
package wyx.leetcode2024.wyx20240325;

import java.util.Stack;

class Solution331 {

    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<String>();
        String[] strs = preorder.split(",");
        for(String str : strs) {
            while(!stack.isEmpty() && "#".equals(str) && "#".equals(stack.peek())) {
                if(stack.size() < 2) return false; 
                stack.pop();
                stack.pop();
            }
            stack.push(str);
        }
        return stack.size() == 1 && "#".equals(stack.peek());
    } 
}
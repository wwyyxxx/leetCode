/*
 * @Author: Tungbo
 * @Date: 2024-07-29 15:50:38
 * @LastEditTime: 2024-07-29 16:06:35
 * @LastEditors: Tungbo
 * @Description: leecode: 155. 最小栈
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240722;

import java.util.Stack;

public class MinStack {
    
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(val, minStack.peek()));
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

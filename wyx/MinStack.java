package wyx;

import java.util.Stack;

/*
 * @Author: Tungbo
 * @Date: 2021-07-26 15:03:05
 * @LastEditTime: 2022-05-26 21:57:04
 * @LastEditors: Tungbo
 * @Description: leecode: 包含min函数的栈
 */
class MinStack1 {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack1() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(minStack.isEmpty() || x<minStack.peek()) minStack.add(x);
        else minStack.add(minStack.peek());
        stack.add(x);
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
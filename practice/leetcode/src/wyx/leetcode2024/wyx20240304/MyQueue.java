/*
 * @Author: Tungbo
 * @Date: 2024-03-04 11:10:45
 * @LastEditTime: 2024-03-04 11:18:26
 * @LastEditors: Tungbo
 * @Description: leecode: 232. 用栈实现队列
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240304;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> in, out;
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        if(!out.empty()) return out.pop();
        while (!in.empty()) {
            out.push(in.pop());
        }
        return out.pop();
    }
    
    public int peek() {
        if(!out.empty()) return out.peek();
        while (!in.empty()) {
            out.push(in.pop());
        }
        return out.peek();
    }
    
    public boolean empty() {
        return in.empty() && out.empty();
    }
}

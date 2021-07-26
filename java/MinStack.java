/*
 * @Author: Tungbo
 * @Date: 2021-07-26 15:03:05
 * @LastEditTime: 2021-07-26 15:08:51
 * @LastEditors: Tungbo
 * @Description: leecode: 包含min函数的栈
 */
class MinStack {

    Stack<Integer> st;
    Stack<Integer> minSt;

    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<Integer>();
        minSt = new Stack<Integer>();
    }
    
    public void push(int x) {
        st.push(x);
        if(minSt.isEmpty() || x<=minSt.peek()) minSt.push(x);
    }
    
    public void pop() {
        if(st.peek().equals(minSt.peek())) minSt.pop();
        st.pop();
    }
    
    public int top() {
        return (int) st.peek();
    }
    
    public int min() {
        return minSt.peek();
    }
}
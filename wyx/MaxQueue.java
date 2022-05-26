package wyx;

import java.util.*;
/*
 * @Author: Tungbo
 * @Date: 2021-09-03 14:45:53
 * @LastEditTime: 2021-09-03 15:52:04
 * @LastEditors: Tungbo
 * @Description: leecode: 队列的最大值
 */
public class MaxQueue {
    
    Queue<Integer> queue;
    Deque<Integer> d;

    public MaxQueue() {
        queue = new LinkedList<Integer>();
        d = new LinkedList<Integer>();
    }
    
    public int max_value() {
        return d.isEmpty() ? -1 : d.peekFirst();
    }
    
    public void push_back(int value) {
        while (!d.isEmpty() && d.peekLast() < value) {
            d.pollLast();
        }
        queue.offer(value);
        d.offerLast(value);
    }
    
    public int pop_front() {
        if(queue.isEmpty()) {
            return -1;
        }
        int ans = queue.poll();
        if(ans == d.peekFirst()) {d.pollFirst();}
        return ans;
    }
}
/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */

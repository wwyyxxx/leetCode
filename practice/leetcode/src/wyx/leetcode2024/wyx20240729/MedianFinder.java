/*
 * @Author: Tungbo
 * @Date: 2024-08-02 17:38:28
 * @LastEditTime: 2024-08-02 17:55:22
 * @LastEditors: Tungbo
 * @Description: leecode: 295. 数据流的中位数
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240729;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> minStack;
    PriorityQueue<Integer> maxStack;
    public MedianFinder() {
        maxStack = new PriorityQueue<>();
        minStack = new PriorityQueue<>((a,b) -> (b - a));
    }
    
    public void addNum(int num) {
        if (minStack.size() != maxStack.size()) {
            maxStack.add(num);
            minStack.add(maxStack.poll());
        } else {
            minStack.add(num);
            maxStack.add(minStack.poll());
        }
    }
    
    public double findMedian() {
        return maxStack.size() != minStack.size() ? maxStack.peek() : (minStack.peek() + maxStack.peek()) / 2.0;
    }
}

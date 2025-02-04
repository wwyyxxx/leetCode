/*
 * @Author: Tungbo
 * @Date: 2022-07-16 12:57:20
 * @LastEditTime: 2022-07-16 13:19:54
 * @LastEditors: Tungbo
 * @Description: leecode: 剑指 Offer II 041. 滑动窗口的平均值
 * 
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
 * 
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220711;

import java.util.LinkedList;

public class MovingAverage {
    
    LinkedList<Integer> queue;
    int size;
    double count;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<Integer>();
        this.size = size;
    }

    public double next(int val) {
        if(queue.size() >= size) {
            count -= queue.poll();
        }
        count += val;
        queue.offerLast(val);
        return count / queue.size();
    }

}

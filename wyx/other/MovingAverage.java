/*
 * @Author: Tungbo
 * @Date: 2022-03-29 20:59:46
 * @LastEditTime: 2022-05-26 21:56:58
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
package wyx.other;

import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {

    int size;
    int count;
    int sum;
    LinkedList<Integer> q = new LinkedList<Integer>();


    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        q.add(val);
        sum += val;
        if(q.size() > size) {
            sum -= q.pollFirst();
        }
        return sum / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
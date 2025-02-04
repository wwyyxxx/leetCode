/*
 * @Author: Tungbo
 * @Date: 2022-06-15 15:49:57
 * @LastEditTime: 2022-06-15 15:53:31
 * @LastEditors: Tungbo
 * @Description: leecode: 剑指 Offer II 059. 数据流的第 K 大数值
 * 
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * 请实现 KthLargest 类：
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220613;

import java.util.PriorityQueue;

public class Solution059 {

    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    int k ;
    public Solution059(int k, int[] nums) {
        for(int i : nums) {
            queue.add(i);
        }
        this.k = k;
    }
    
    public int add(int val) {
        queue.add(val);
        while(queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
    
}

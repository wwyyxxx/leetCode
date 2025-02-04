/*
 * @Author: Tungbo
 * @Date: 2024-08-01 17:39:33
 * @LastEditTime: 2024-08-01 17:44:32
 * @LastEditors: Tungbo
 * @Description: leecode: 215. 数组中的第K个最大元素
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240729;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution251 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
            
        });
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        while (!queue.isEmpty() && k > 1) {
            queue.poll();
            k--;
        }
        return queue.poll();
    }
}

/*
 * @Author: Tungbo
 * @Date: 2024-06-14 20:48:15
 * @LastEditTime: 2024-06-14 20:51:09
 * @LastEditors: Tungbo
 * @Description: leecode: 239. 滑动窗口最大值
 */
package wyx.leetcode2024.wyx20240610;

import java.util.Deque;
import java.util.LinkedList;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<Integer>();
        int[] res = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; j++, i++) {
            if(i > 0 && deque.peekFirst() == nums[i - 1]) {
                deque.removeFirst();
            }
            while(!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            if(i >= 0) res[i] = deque.peekFirst();
        }
        return res;
    }
}

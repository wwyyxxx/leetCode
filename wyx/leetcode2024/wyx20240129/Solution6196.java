/*
 * @Author: Tungbo
 * @Date: 2024-02-05 14:59:20
 * @LastEditTime: 2024-02-05 14:59:22
 * @LastEditors: Tungbo
 * @Description: leecode: 1696. 跳跃游戏 VI
 */
package wyx.leetcode2024.wyx20240129;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution6196 {

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(0);
        for (int i = 1; i < n; i++) {
            while (queue.peekFirst() < i - k) {
                queue.pollFirst();
            }
            dp[i] = dp[queue.peekFirst()] + nums[i];
            while (!queue.isEmpty() && dp[queue.peekLast()] <= dp[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return dp[n - 1];
    }
}
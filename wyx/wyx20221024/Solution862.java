/*
 * @Author: Tungbo
 * @Date: 2022-10-26 10:42:21
 * @LastEditTime: 2022-10-26 15:18:10
 * @LastEditors: Tungbo
 * @Description: leecode: 862. 和至少为 K 的最短子数组
 * 
 * 给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。
 * 如果不存在这样的 子数组 ，返回 -1 
 * 子数组 是数组中 连续 的一部分。
 * 
 */
package wyx.wyx20221024;

import java.util.LinkedList;

public class Solution862 {

    public int shortestSubarray(int[] nums, int k) {
        int ans = nums.length + 1;
        long[] fontSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            fontSum[i + 1] = nums[i] + fontSum[i];
        LinkedList<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i <= nums.length; i++) {
            long sum = fontSum[i];
            while (!q.isEmpty() && sum - fontSum[q.peekFirst()] >= k)
                ans = Math.min(ans, i - q.pollFirst());
            while (!q.isEmpty() && fontSum[q.peekLast()] >= sum)
                q.pollLast(); // 优化二
            q.addLast(i);
        }
        return ans > nums.length ? -1 : ans;
    }

    public int shortestSubarray1(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int l = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= k) {
                ans = Math.min(sum, i - l + 1);
                sum -= nums[l++];
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}

/*
 * @Author: Tungbo
 * @Date: 2024-08-05 16:26:18
 * @LastEditTime: 2024-08-05 16:43:16
 * @LastEditors: Tungbo
 * @Description: leecode: 45. 跳跃游戏 II
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240805;

class Solution45 {

    public int jump(int[] nums) {
        int res = 0;
        int max = 0;
        int cur = 0;
        for (int i = 0; i < nums.length -1; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == cur) {
                cur = max;
                res++;
            }
        }
        return res;
    }
}
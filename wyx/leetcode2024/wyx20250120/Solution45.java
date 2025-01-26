/*
 * @Author: Tungbo
 * @Date: 2025-01-27 00:06:50
 * @LastEditTime: 2025-01-27 00:34:50
 * @LastEditors: Tungbo
 * @Description: leecode: 45. 跳跃游戏 II
 */
package wyx.leetcode2024.wyx20250120;

import java.util.Arrays;

public class Solution45 {
    public int jump(int[] nums) {
        int res = 0;
        int n = nums.length;
        int maxJump = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            maxJump = Math.max(maxJump, nums[i] + i);
            if(i == end) {
                end = maxJump;
                res++;
            }
        }
        return res;
    }
}

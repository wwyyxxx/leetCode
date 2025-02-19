/*
 * @Author: Tungbo
 * @Date: 2025-02-19 18:44:42
 * @LastEditTime: 2025-02-19 18:48:01
 * @LastEditors: Tungbo
 * @Description: leecode: 1493. 删掉一个元素以后全为 1 的最长子数组
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250217;

public class Solution1493 {
    public int longestSubarray(int[] nums) {
        int k = 0;
        int res = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                k++;
            }
            if (k <= 1) {
                res = Math.max(res, i -j);
            }
            while (k > 1) {
                if (nums[j++] == 0) {
                    k--;
                }
            }
        }
        return res;
    }
}

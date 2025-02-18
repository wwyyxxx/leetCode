/*
 * @Author: Tungbo
 * @Date: 2025-02-18 21:48:54
 * @LastEditTime: 2025-02-18 21:48:57
 * @LastEditors: Tungbo
 * @Description: leecode: 1004. 最大连续1的个数 III
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250217;

public class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0;
        int res = 0;
        while (r < nums.length) {
            if (nums[r++] == 0) {
                k--;
            }
            if(k >= 0) res = Math.max(r - l, res);
            while (k < 0) {
                if (nums[l++] == 0) {
                    k++;
                }
            }
        }
        return res;
    }
}

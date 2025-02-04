/*
 * @Author: Tungbo
 * @Date: 2025-01-13 14:07:44
 * @LastEditTime: 2025-01-13 14:07:58
 * @LastEditors: Tungbo
 * @Description: leecode: 2270. 分割数组的方案数
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250106;

public class Solution2279 {
    public int waysToSplitArray(int[] nums) {
        long total = 0;
        for(int num : nums) {
            total += num;
        }
        int ans = 0;
        long s = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            s += nums[i];
            if (s * 2 >= total) {
                ans++;
            }
        }
        return ans;
    }
}

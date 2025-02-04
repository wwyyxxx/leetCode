/*
 * @Author: Tungbo
 * @Date: 2022-12-11 19:07:35
 * @LastEditTime: 2022-12-11 19:07:36
 * @LastEditors: Tungbo
 * @Description: leecode: [1827] 最少操作使数组递增
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221205;

public class Solution1827 {
    public int minOperations(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            while(nums[i] <= nums[i -1]) {
                nums[i] += 1;
                ans++;
            }
        }
        return ans;
    }
}

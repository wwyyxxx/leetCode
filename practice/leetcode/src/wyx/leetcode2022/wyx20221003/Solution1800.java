/*
 * @Author: Tungbo
 * @Date: 2022-10-07 18:23:14
 * @LastEditTime: 2022-10-07 18:35:45
 * @LastEditors: Tungbo
 * @Description: leecode: 1800. 最大升序子数组和
 * 
 * 给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和
 * 子数组是数组中的一个连续数字序列
 * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221003;

public class Solution1800 {

    public int maxAscendingSum(int[] nums) {
        int max = 0;
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = nums[i];
            ans = Math.max(sum, ans);
        }
        return ans;
    }

}

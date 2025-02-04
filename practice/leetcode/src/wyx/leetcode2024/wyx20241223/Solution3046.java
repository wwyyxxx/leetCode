/*
 * @Author: Tungbo
 * @Date: 2024-12-28 16:52:13
 * @LastEditTime: 2024-12-28 17:04:05
 * @LastEditors: Tungbo
 * @Description: leecode: 3046. 分割数组
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20241223;

import java.util.Arrays;

public class Solution3046 {
    public boolean isPossibleToSplit(int[] nums) {
        int n = nums.length;
        if(n % 2 != 0) {
            return false;
        }
        Arrays.sort(nums);
        int[] dic = new int[101];
        for(int i = 0; i < n; i++) {
            dic[nums[i]]++;
            if (dic[nums[i]] >= 3) {
                return false;
            }
        }
        return true;
    }
}

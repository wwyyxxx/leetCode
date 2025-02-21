/*
 * @Author: Tungbo
 * @Date: 2025-02-21 10:59:04
 * @LastEditTime: 2025-02-21 11:05:36
 * @LastEditors: Tungbo
 * @Description: leecode: 724. 寻找数组的中心下标
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250217;

import java.util.Arrays;

public class Solution724 {
    public int pivotIndex(int[] nums) {
        int sum  = Arrays.stream(nums).sum();
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * cnt + nums[i] == sum) {
                return i;
            }
            cnt += nums[i];
        }
        return -1;
    }
}

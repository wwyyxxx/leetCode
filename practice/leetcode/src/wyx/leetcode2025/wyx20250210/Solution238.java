/*
 * @Author: Tungbo
 * @Date: 2025-02-12 12:13:56
 * @LastEditTime: 2025-02-12 12:23:26
 * @LastEditors: Tungbo
 * @Description: leecode: 238. 除自身以外数组的乘积
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250210;

import java.util.Arrays;

public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int max = 1;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            max = num * max;
        }
        int[] result = new int[nums.length];
        int zeroCnt = 0;
        for (int i = 0; i < result.length; i++) {
            if (nums[i] == 0) {
                Arrays.fill(result, 0);
                result[i] = max;
                zeroCnt++;
            } else {
                result[i] = zeroCnt >= 1 ? 0 : max / nums[i];
            }
        }
        if (zeroCnt > 1) {
            Arrays.fill(result, 0);
        }
        return result;
    }
}

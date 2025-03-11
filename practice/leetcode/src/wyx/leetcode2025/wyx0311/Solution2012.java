/*
 * @Author: Tungbo
 * @Date: 2025-03-11 21:48:18
 * @LastEditTime: 2025-03-11 21:56:22
 * @LastEditors: Tungbo
 * @Description: leecode: 2012. 数组美丽值求和
 */
package practice.leetcode.src.wyx.leetcode2025.wyx0311;

public class Solution2012 {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;

        int[] sufMin = new int[n]; // 后缀最小值
        sufMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i > 1; i--) {
            sufMin[i] = Math.min(sufMin[i + 1], nums[i]);
        }


        int sum = 0;
        int preMax = nums[0]; // 前缀最大值
        for (int i = 1; i < n - 1; i++) {
            int x = nums[i];
            // 此时 preMax 表示 [0, i-1] 中的最大值
            if (preMax < x && x < sufMin[i + 1]) {
                sum += 2;
            } else if (nums[i - 1] < x && x < nums[i + 1]) {
                sum++;
            }
            // 更新后 preMax 表示 [0, i] 中的最大值
            preMax = Math.max(preMax, x);
        }

        return sum;
    }
}

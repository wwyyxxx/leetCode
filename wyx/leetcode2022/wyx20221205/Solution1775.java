/*
 * @Author: Tungbo
 * @Date: 2022-12-07 10:42:53
 * @LastEditTime: 2022-12-07 11:18:17
 * @LastEditors: Tungbo
 * @Description: leecode: 1775. 通过最少操作次数使数组的和相等
 * 
 * 给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。
 * 每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。
 * 请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。
 * 
 */
package wyx.wyx20221205;

import java.util.Arrays;

public class Solution1775 {

    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        if (6 * nums1.length < nums2.length || 6 * nums2.length < nums1.length)
            return -1; // 优化
        int diff = sum2 - sum1, step = 0;
        if (diff < 0) {
            diff=-diff;
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int[] cnt = new int[6];
        for (int x : nums1)
            ++cnt[6 - x];
        for (int x : nums2)
            ++cnt[x - 1];
        for (int i = 5;; i--) {
            if (i * cnt[i] >= diff) {
                return step + (diff + i - 1) / i;//diff/i + 1
            }
            step += cnt[i];
            diff -= i * cnt[i];
        }
    }

}

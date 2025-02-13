/*
 * @Author: Tungbo
 * @Date: 2025-02-13 11:35:00
 * @LastEditTime: 2025-02-13 11:57:06
 * @LastEditors: Tungbo
 * @Description: leecode: 334. 递增的三元子序列
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250210;

public class Soution334 {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int frist = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num > second) {
                return true;
            } else if (num > frist) {
                second = num;
            } else {
                frist = num;
            }
        }
        return false;
    }
}

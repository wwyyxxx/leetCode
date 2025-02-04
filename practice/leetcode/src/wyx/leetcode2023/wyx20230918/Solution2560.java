/*
 * @Author: Tungbo
 * @Date: 2023-09-19 14:26:48
 * @LastEditTime: 2023-09-19 15:28:52
 * @LastEditors: Tungbo
 * @Description: leecode: 2560. 打家劫舍 IV
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230918;

public class Solution2560 {
    public int minCapability(int[] nums, int k) {
        int left = 0, right = 0;
        for (int x : nums) {
            right = Math.max(right, x);
        }
        while (left + 1 < right) { // 开区间写法
            int mid = (left + right) >>> 1;
            if (check(nums, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int[] nums, int k, int mx) {
        int f0 = 0, f1 = 0;
        for (int x : nums) {
            if (x > mx) {
                f0 = f1;
            } else {
                int tmp = f1;
                f1 = Math.max(f1, f0 + 1);
                f0 = tmp;
            }
        }
        return f1 >= k;
    }
}

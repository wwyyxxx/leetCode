package practice.leetcode.src.wyx.leetcode2025.wyx20250210;

/*
 * @Author: Tungbo
 * @Date: 2025-02-12 10:12:01
 * @LastEditTime: 2025-02-12 10:15:44
 * @LastEditors: Tungbo
 * @Description: leecode: 1760. 袋子里最少数目的球
 */
public class Soluton1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }

        int left = 0; // 循环不变量 check(left) == false
        int right = mx; // 循环不变量 check(right) == true
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(nums, maxOperations, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int[] nums, int maxOperations, int m) {
        long cnt = 0;
        for (int x : nums) {
            cnt += (x - 1) / m;
        }
        return cnt <= maxOperations;
    }
}

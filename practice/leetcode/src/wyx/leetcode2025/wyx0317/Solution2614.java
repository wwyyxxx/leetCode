package practice.leetcode.src.wyx.leetcode2025.wyx0317;

/*
 * @Author: Tungbo
 * @Date: 2025-03-17 22:36:41
 * @LastEditTime: 2025-03-18 22:15:05
 * @LastEditors: Tungbo
 * @Description: leecode: 2614. 对角线上的质数
 */
public class Solution2614 {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i][i];
            if (x > ans && isPrime(x)) {
                ans = x;
            }
            x = nums[i][n - 1 - i];
            if (x > ans && isPrime(x)) {
                ans = x;
            }
        }
        return ans;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return n >= 2;
    }
}

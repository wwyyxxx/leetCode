package practice.leetcode.src.wyx.leetcode2022.wyx20221121;

/*
 * @Author: Tungbo
 * @Date: 2022-11-22 11:19:55
 * @LastEditTime: 2022-11-22 15:19:44
 * @LastEditors: Tungbo
 * @Description: leecode: 878. 第 N 个神奇数字
 * 
 * 一个正整数如果能被 a 或 b 整除，那么它是神奇的。
 * 给定三个整数 n , a , b ，返回第 n 个神奇的数字。
 * 因为答案可能很大，所以返回答案 对 109 + 7 取模 后的值。
 * 
 */
public class Solution878 {
    private static final long MOD = (long) 1e9 + 7;
    public int nthMagicalNumber(int n, int a, int b) {
        long lcm = a / gcd(a, b) * b;
        long left = 0, right = (long) Math.max(a, b) * n; // 开区间 (left, right)
        while (left + 1 < right) { // 开区间不为空
            long mid = left + (right - left) / 2;
            if (mid / a + mid / b - mid / lcm >= n)
                right = mid; // 范围缩小到 (left, mid)
            else
                left = mid; // 范围缩小到 (mid, right)
        }
        return (int) (right % MOD);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}

package practice.leetcode.src.wyx.leetcode2024.wyx20240318;
/*
 * @Author: Tungbo
 * @Date: 2024-03-20 22:43:48
 * @LastEditTime: 2024-03-20 22:51:59
 * @LastEditors: Tungbo
 * @Description: leecode: 1969. 数组元素的最小非零乘积
 */
public class Solution1969 {
    private static final int MOD = 1_000_000_007;

    private long pow(long x, int p) {
        x %= MOD;
        long res = 1;
        while (p-- > 0) {
            res = res * x % MOD;
            x = x * x % MOD;
        }
        return res;
    }

    public int minNonZeroProduct(int p) {
        long k = (1L << p) - 1;
        return (int) (k % MOD * pow(k - 1, p - 1) % MOD);
    }
}

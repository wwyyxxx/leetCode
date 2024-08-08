/*
 * @Author: Tungbo
 * @Date: 2024-08-08 18:37:59
 * @LastEditTime: 2024-08-08 18:54:04
 * @LastEditors: Tungbo
 * @Description: leecode: 70. 爬楼梯
 */
package wyx.leetcode2024.wyx20240805;

public class Solution70 {
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}

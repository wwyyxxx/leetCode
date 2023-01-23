/*
 * @Author: Tungbo
 * @Date: 2023-01-23 15:01:17
 * @LastEditTime: 2023-01-23 15:03:34
 * @LastEditors: Tungbo
 * @Description: leecode: 2303. 计算应缴税款总额
 */
package wyx.wyx20230123;

public class Solution2303 {
    public double calculateTax(int[][] brackets, int income) {
        int ans = 0, prev = 0;
        for (var e : brackets) {
            int upper = e[0], percent = e[1];
            ans += Math.max(0, Math.min(income, upper) - prev) * percent;
            prev = upper;
        }
        return ans / 100.0;
    }
}

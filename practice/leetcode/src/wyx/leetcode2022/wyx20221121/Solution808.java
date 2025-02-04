/*
 * @Author: Tungbo
 * @Date: 2022-11-21 14:17:20
 * @LastEditTime: 2022-11-21 15:12:44
 * @LastEditors: Tungbo
 * @Description: leecode: 808. 分汤
 * 
 * 有 A 和 B 两种类型 的汤。一开始每种类型的汤有 n 毫升。有四种分配操作：
 *  提供 100ml 的 汤A 和 0ml 的 汤B 。
 *  提供 75ml 的 汤A 和 25ml 的 汤B 。
 *  提供 50ml 的 汤A 和 50ml 的 汤B 。
 *  提供 25ml 的 汤A 和 75ml 的 汤B 。
 * 当我们把汤分配给某人之后，汤就没有了。
 * 每个回合，我们将从四种概率同为 0.25 的操作中进行分配选择。
 * 如果汤的剩余量不足以完成某次操作，我们将尽可能分配。
 * 当两种类型的汤都分配完时，停止操作。
 * 注意 不存在先分配 100 ml 汤B 的操作。
 * 需要返回的值： 
 *  汤A 先分配完的概率 +  汤A和汤B 同时分配完的概率 / 2。返回值在正确答案 10-5 的范围内将被认为是正确的。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221121;

public class Solution808 {
    public double soupServings(int n) {
        n = (int) Math.ceil((double) n / 25);
        if (n >= 179)
            return 1.0;
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 0.5;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1.0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[Math.max(0, i - 4)][j] + dp[Math.max(0, i - 3)][Math.max(0, j - 1)]
                        + dp[Math.max(0, i - 2)][Math.max(0, j - 2)] + dp[Math.max(0, i - 1)][Math.max(0, j - 3)])
                        / 4.0;
            }
        }
        return dp[n][n];
    }
}

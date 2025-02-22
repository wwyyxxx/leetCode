/*
 * @Author: Tungbo
 * @Date: 2023-02-22 15:01:52
 * @LastEditTime: 2023-02-22 15:13:42
 * @LastEditors: Tungbo
 * @Description: leecode: 1140. 石子游戏 II
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230220;

public class Solution1140 {
    public int stoneGameII(int[] piles) {
        int len = piles.length, sum = 0;
        int[][] dp = new int[len][len+1];
        for (int i = len -1; i >= 0; i--) {
            sum += piles[i];
            for (int M = 1; M <= len; M++) {
                if(i+2*M >= len){
                    dp[i][M] = sum;
                } else {
                    for (int x = 1; x <= 2*M; x++){
                        dp[i][M] = Math.max(dp[i][M], sum - dp[i+x][Math.max(M, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}

package wyx.wyx20220509;

/*
 * @Author: Tungbo
 * @Date: 2022-05-14 18:55:12
 * @LastEditTime: 2022-05-26 21:58:27
 * @LastEditors: Tungbo
 * @Description: leecode:  比特位计数
 * 
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * 
 */
public class Solution338 {
    
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if(i % 2 == 1) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = dp[i%2];
            }
        }
        return dp;
    }

}

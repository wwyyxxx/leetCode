package wyx.wyx20220530;

/*
 * @Author: Tungbo
 * @Date: 2022-06-03 14:10:21
 * @LastEditTime: 2022-06-03 14:19:08
 * @LastEditors: Tungbo
 * @Description: leecode: 279. 完全平方数
 * 
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * 
 */
public class Solution279 {

    public static void main(String[] args) {
        System.out.println((int) Math.sqrt(13));
        // Math.pow(a, b)
    }

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        // 0的时候只为0
        for(int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            // 查找符合条件的最小的值
            for(int j =1; j*j<=i; j++) {
                min = Math.min(min, dp[i-j*j]);
            }
            dp[i] = min+1;
        }
        return dp[n];
    }
}
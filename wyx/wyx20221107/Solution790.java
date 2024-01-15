/*
 * @Author: Tungbo
 * @Date: 2022-11-12 22:59:14
 * @LastEditTime: 2022-11-12 23:06:33
 * @LastEditors: Tungbo
 * @Description: leecode: 790. 多米诺和托米诺平铺
 * 
 * 有两种形状的瓷砖：一种是 2 x 1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。
 * 给定整数 n ，返回可以平铺 2 x n 的面板的方法的数量。返回对 109 + 7 取模 的值
 * 平铺指的是每个正方形都必须有瓷砖覆盖。
 * 两个平铺不同，当且仅当面板上有四个方向上的相邻单元中的两个，使得恰好有一个平铺有一个瓷砖占据两个正方形
 * 
 */
package wyx.wyx20221107;

public class Solution790 {
    public int numTilings(int n) {
        if(n == 1) return 1;
        long[] f = new long[n+1];
        int MOD = (int)1e9 + 7;
        f[0] = f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            f[i] = (f[i-1] * 2 + f[i-3]) % MOD;
        }
        return (int)f[n];
    }
}

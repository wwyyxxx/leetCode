/*
 * @Author: Tungbo
 * @Date: 2022-06-25 11:03:54
 * @LastEditTime: 2022-06-25 11:37:52
 * @LastEditors: Tungbo
 * @Description: leecode: 剑指 Offer II 091. 粉刷房子
 * 
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的。
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
 * 请计算出粉刷完所有房子最少的花费成本。
 * 
 */
package wyx.wyx20220620;

import java.util.Arrays;

public class Solution091 {

    public int minCost(int[][] costs) {
        int[] dp = new int[3];
        //初始化第一行数据
        for (int i = 0; i < 3; i++) {
            dp[i] = costs[0][i];
        }
        //从第二行开始
        for (int i = 1; i < costs.length; i++) {
            int[] tempDp = new int[3];
            for (int j = 0; j < 3; j++) {
                // 0 : 1 2
                // 1 : 0 2
                // 2 : 0 1
                //不是相邻的取最小相加， 穷举所有
                tempDp[j] = Math.min(dp[(j+1)%3], dp[(j+2)%3]) + costs[i][j];
            }
            dp = tempDp;
        }
        return Arrays.stream(dp).min().getAsInt();
    }

}

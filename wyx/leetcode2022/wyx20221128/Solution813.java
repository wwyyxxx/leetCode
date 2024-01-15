/*
 * @Author: Tungbo
 * @Date: 2022-11-28 10:10:34
 * @LastEditTime: 2022-11-28 11:10:31
 * @LastEditors: Tungbo
 * @Description: leecode: 813. 最大平均值和的分组
 * 
 * 给定数组 nums 和一个整数 k 。我们将给定的数组 nums 分成 最多 k 个相邻的非空子数组 。 分数 由每个子数组内的平均值的总和构成
 * 注意我们必须使用 nums 数组中的每一个数进行分组，并且分数不一定需要是整数
 * 返回我们所能得到的最大 分数 是多少。答案误差在 10-6 内被视为是正确的
 * 
 */
package wyx.wyx20221128;

import java.util.Arrays;

public class Solution813 {

    Double[][] f;
    int[] sum;
    int n;

    public double largestSumOfAverages1(int[] nums, int k) {
        n = nums.length;
        f = new Double[n + 1][n + 1];
        sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }
        return dfs(0, k);
    }

    private double dfs(int i, int k) {
        if (i == n)
            return 0;
        if (k == 1)
            return (sum[n] - sum[i]) / (n - i);
        if (f[i][k] != null)
            return f[i][k];
        double ans = 0;
        for (int j = i; j < n; j++) {
            double t = (sum[j + 1] - sum[i]) / (j - i + 1) + dfs(j + 1, k - 1);
            ans = Math.max(ans, t);
        }
        return f[i][k] = ans;
    }

    public double largestSumOfAverages(int[] nums, int k) {
        Arrays.sort(nums);// 不能排序
        double ans = 0;
        double temp = 0;
        int m = nums.length - k + 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (k == 1)
                temp += nums[i];
            else {
                ans += nums[i];
                k--;
            }
        }
        ans += (temp / m);
        return ans;
    }
}

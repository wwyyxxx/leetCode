/*
 * @Author: Tungbo
 * @Date: 2022-09-03 15:17:56
 * @LastEditTime: 2022-09-03 16:27:44
 * @LastEditors: Tungbo
 * @Description: leecode: 646. 最长数对链
 * 
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * 
 */
package wyx.wyx20220829;

import java.util.Arrays;

public class Solution646 {

    //贪心
    public int findLongestChain1(int[][] pairs) {
        int ans = 0;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int curr = Integer.MIN_VALUE;
        for (int i = 0; i < pairs.length; i++) {
            if (curr < pairs[i][0]) {
                ans++;
                curr = pairs[i][0];
            }
        }
        return ans;
    }

    //动规
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if(pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[dp.length -1];
    }
}

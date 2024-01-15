/*
 * @Author: Tungbo
 * @Date: 2023-03-22 22:24:30
 * @LastEditTime: 2023-03-22 23:10:19
 * @LastEditors: Tungbo
 * @Description: leecode: 1626. 无矛盾的最佳球队
 */
package wyx.wyx20230320;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1626 {

    public int bestTeamScore(int[] scores, int[] ages) {
        // PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>()
        // {
        // @Override
        // public int compare(int[] p1, int[] p2) {
        // return p2[0] - p1[0];
        // }
        // });
        // for (int i = 0; i < ages.length; i++) {
        // queue.offer(new int[]{scores[i], ages[i]});
        // }
        int[][] temp = new int[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            temp[i] = new int[] { scores[i], ages[i] };
        }
        //分数升序，年龄升序
        Arrays.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p2[0] != p1[0] ? p1[0] - p2[0] : p1[1] - p2[1];
            }
        });
        int[] dp = new int[ages.length + 1];
        int ans = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < i; j++) {
                //寻找年龄比当前小的最佳项
                if(temp[j][1] <= temp[i][1]) dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i] += temp[i][0]; //累加
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}

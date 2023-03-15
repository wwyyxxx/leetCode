/*
 * @Author: Tungbo
 * @Date: 2023-03-15 20:07:58
 * @LastEditTime: 2023-03-15 20:08:02
 * @LastEditors: Tungbo
 * @Description: leecode: 1615. 最大网络秩
 */
package wyx.wyx20230313;

public class Solution1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] g= new int[n][n];
        int[] cnt = new int[n];
        for(int[] road : roads) {
            int a = road[0], b = road[1];
            g[a][b] = 1;
            g[b][a] = 1;
            cnt[a]++;
            cnt[b]++;
        }
        int ans = 0;
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                ans = Math.max(ans, cnt[a] + cnt[b] - g[a][b]);
            }
        }
        return ans;
    }
}

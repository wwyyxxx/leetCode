package wyx.wyx20230501;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: Tungbo
 * @Date: 2023-05-01 16:20:33
 * @LastEditTime: 2023-05-01 17:03:13
 * @LastEditors: Tungbo
 * @Description: leecode: 1376. 通知所有员工所需的时间
 */
public class Solution1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            if(manager[i] >= 0) g[manager[i]].add(i);
        }
        return dfs(g, informTime, headID);
    }

    private int dfs(List<Integer>[] g, int[] informTime, int x) {
        int maxPathSum = 0;
        for(int y :g[x]) {
            maxPathSum = Math.max(maxPathSum, dfs(g,informTime,y));
        }
        return maxPathSum + informTime[x];
    }
}

/*
 * @Author: Tungbo
 * @Date: 2024-05-15 16:41:45
 * @LastEditTime: 2024-05-15 16:41:47
 * @LastEditors: Tungbo
 * @Description: leecode: 2589. 完成所有任务的最少时间
 */
package wyx.leetcode2024.wyx20240513;

import java.util.Arrays;

public class Solution2589 {
    public int findMinimumTime(int[][] tasks){
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        int ans = 0;
        int mx = tasks[tasks.length - 1][1];
        boolean[] run = new boolean[mx + 1];
        for (int[] t : tasks) {
            int start = t[0];
            int end = t[1];
            int d = t[2];
            for (int i = start; i <= end; i++) {
                if (run[i]) {
                    d--; // 去掉运行中的时间点
                }
            }
            for (int i = end; d > 0; i--) { // 剩余的 d 填充区间后缀
                if (!run[i]) {
                    run[i] = true; // 运行
                    d--;
                    ans++;
                }
            }
        }
        return ans;
    }
}

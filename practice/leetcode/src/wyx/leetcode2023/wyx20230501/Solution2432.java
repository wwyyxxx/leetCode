/*
 * @Author: Tungbo
 * @Date: 2023-05-05 15:50:43
 * @LastEditTime: 2023-05-05 16:18:05
 * @LastEditors: Tungbo
 * @Description: leecode: 2432. 处理用时最长的那个任务的员工
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230501;

public class Solution2432 {
    public int hardestWorker(int n, int[][] logs) {
        int ans = n;
        int maxTime = 0, lastTime = 0;
        for (int i = 0; i < logs.length; i++) {
            int id = logs[i][0], t = logs[i][1];
            int d = t - lastTime;
            if (d >= maxTime) {
                ans = d == maxTime ? Math.min(ans,id) : id;
                maxTime = d;
            }
            lastTime = t;
        }
        return ans;
    }
}

/*
 * @Author: Tungbo
 * @Date: 2022-10-22 15:23:40
 * @LastEditTime: 2022-10-22 15:45:45
 * @LastEditors: Tungbo
 * @Description: leecode: 1235. 规划兼职工作
 * 
 * 你打算利用空闲时间来做兼职工作赚些零花钱。
 * 这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]
 * 给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬
 * 注意，时间上出现重叠的 2 份工作不能同时进行。
 * 如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。
 * 
 */
package wyx.wyx20221017;

import java.util.Arrays;

public class Solution1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        var n = startTime.length;
        var jobs = new int[n][];
        for (var i = 0; i < n; ++i)
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]); // 按照结束时间排序

        var f = new int[n + 1];
        for (var i = 0; i < n; ++i) {
            var j = search(jobs, i, jobs[i][0]);
            f[i + 1] = Math.max(f[i], f[j + 1] + jobs[i][2]);
        }
        return f[n];
    }

    // 返回 endTime <= upper 的最大下标
    private int search(int[][] jobs, int right, int upper) {
        var left = -1;
        while (left + 1 < right) {
            var mid = (left + right) / 2;
            if (jobs[mid][1] <= upper) left = mid;
            else right = mid;
        }
        return left;
    }
}

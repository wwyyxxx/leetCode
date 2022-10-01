/*
 * @Author: Tungbo
 * @Date: 2022-07-22 15:25:31
 * @LastEditTime: 2022-07-22 16:23:51
 * @LastEditors: Tungbo
 * @Description: leecode: 757. 设置交集大小至少为2
 * 
 * 一个整数区间 [a, b]  ( a < b ) 代表着从 a 到 b 的所有连续整数，包括 a 和 b
 * 给你一组整数区间intervals，请找到一个最小的集合 S，使得 S 里的元素与区间intervals中的每一个整数区间都至少有2个元素相交
 * 输出这个最小集合S的大小
 * 
 */

package wyx.wyx20220718;

import java.util.Arrays;
import java.util.Comparator;

public class Solution757 {

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return b[1] - a[1];
                return a[0] - b[0];
            }
        });

        int n = intervals.length;
        //初始的两个元素
        int cur = intervals[n - 1][0];
        int next = intervals[n - 1][0] + 1;
        int ans = 2;
        //从后向前遍历
        for (int i = n - 2; i >= 0; i--) {
            //开始分类讨论
            if (intervals[i][1] >= next) {
                continue;
            } else if (intervals[i][1] < cur) {
                cur = intervals[i][0];
                next = intervals[i][0] + 1;
                ans = ans + 2;
            } else {
                next = cur;
                cur = intervals[i][0];
                ans++;
            }
        }
        return ans;
    }

}

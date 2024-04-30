/*
 * @Author: Tungbo
 * @Date: 2024-04-30 23:54:51
 * @LastEditTime: 2024-04-30 23:54:53
 * @LastEditors: Tungbo
 * @Description: leecode: 2798. 满足目标工作时长的员工数目
 */
package wyx.leetcode2024.wyx20240428;

public class Solution2798 {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int res = 0;
        for(int hour : hours) {
            if(hour >= target) res++;
        }
        return res;
    }
}

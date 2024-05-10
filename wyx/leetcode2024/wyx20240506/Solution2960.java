/*
 * @Author: Tungbo
 * @Date: 2024-05-10 15:10:07
 * @LastEditTime: 2024-05-10 15:10:09
 * @LastEditors: Tungbo
 * @Description: leecode: 2960. 统计已测试设备
 */
package wyx.leetcode2024.wyx20240506;

public class Solution2960 {
    public int countTestedDevices(int[] batteryPercentages) {
        int res = 0;
        for(int batteryPercentage : batteryPercentages) {
            if(batteryPercentage - res > 0) {
                res++;
            }
        }
        return res;
    }
}

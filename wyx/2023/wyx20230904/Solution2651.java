/*
 * @Author: Tungbo
 * @Date: 2023-09-12 15:36:54
 * @LastEditTime: 2023-09-12 15:42:05
 * @LastEditors: Tungbo
 * @Description: leecode: 2651. 计算列车到站时间
 */
package wyx.wyx20230904;

public class Solution2651 {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}

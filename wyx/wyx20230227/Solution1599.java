package wyx.wyx20230227;
/*
 * @Author: Tungbo
 * @Date: 2023-03-05 11:50:23
 * @LastEditTime: 2023-03-05 11:50:27
 * @LastEditors: Tungbo
 * @Description: leecode: 1599. 经营摩天轮的最大利润
 */
public class Solution1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int ans = -1;
        int wait = 0, max = 0,i = 0;
        int profix = 0;
        while(i < customers.length || wait > 0) {
            wait += i < customers.length ? customers[i] : 0;
            int up = Math.min(4,wait);
            wait -= up;
            i++;
            profix += up * boardingCost - runningCost;
            if(profix > max) {
                max = profix;
                ans = i;
            }
        }
        return ans;
    }
}

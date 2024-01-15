/*
 * @Author: Tungbo
 * @Date: 2023-09-20 11:39:49
 * @LastEditTime: 2023-09-20 11:39:51
 * @LastEditors: Tungbo
 * @Description: leecode: LCP 06. 拿硬币
 */
package wyx.wyx20230918;

public class Solution06 {
    public int minCount(int[] coins) {
        int sum = 0;
        for(int i = 0; i < coins.length; i++) {
            sum += (coins[i] + 1) / 2;
        }
        return sum;
    }
}

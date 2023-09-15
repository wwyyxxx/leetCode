/*
 * @Author: Tungbo
 * @Date: 2023-09-15 17:32:07
 * @LastEditTime: 2023-09-15 17:32:10
 * @LastEditors: Tungbo
 * @Description: leecode: LCP 50. 宝石补给
 */
package wyx.wyx20230912;

public class Solution50 {
    public int giveGem(int[] gem, int[][] operations) {
        for(int i = 0; i < operations.length; i++) {
            int[] operation = operations[i];
            int t = gem[operation[0]] / 2;
            gem[operation[0]] -= t;
            gem[operation[1]] += t;
        }
        int max = gem[0], min = gem[0];
        for(int i =0; i < gem.length; i++) {
            max = Math.max(gem[i],max);
            min = Math.min(gem[i],min);
        }
        return max - min;
    }
}

/*
 * @Author: Tungbo
 * @Date: 2024-04-23 19:53:42
 * @LastEditTime: 2024-04-23 19:58:33
 * @LastEditors: Tungbo
 * @Description: leecode: 1052. 爱生气的书店老板
 */
package wyx.leetcode2024.wyx20240422;

public class Solution1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length, ans = 0;
        for (int i = 0; i < n; i++) {
            if(grumpy[i] == 0) {
                ans += customers[i];
                customers[i] =0;
            }
        }
        int cur = ans;
        for (int i = 0; i < n; i++) {
            cur += customers[i];
            if(i >= minutes) cur -= customers[i - minutes];
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}

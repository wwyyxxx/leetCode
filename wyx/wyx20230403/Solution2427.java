/*
 * @Author: Tungbo
 * @Date: 2023-04-05 13:43:47
 * @LastEditTime: 2023-04-05 13:44:11
 * @LastEditors: Tungbo
 * @Description: leecode: 2427. 公因子的数目
 */
package wyx.wyx20230403;

public class Solution2427 {
    public int commonFactors(int a, int b) {
        int ans = 0;
        int min = Math.min(a,b);
        for(int i = 1; i <= min; i++) {
            if(a % i == 0 && b % i == 0) ans++;
        }
        return ans;
    }
}

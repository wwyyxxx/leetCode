/*
 * @Author: Tungbo
 * @Date: 2023-02-15 10:25:38
 * @LastEditTime: 2023-02-15 10:26:41
 * @LastEditors: Tungbo
 * @Description: leecode: 1250. 检查「好数组」
 */
package wyx.wyx20230213;

public class Solution1250 {
    public boolean isGoodArray(int[] nums) {
        int g = 0;
        for(int num : nums) {
            g = gcd(num,g);
        }
        return g==1;
    }

    private int gcd(int num, int g) {
        return g == 0? num : gcd(g, num % g);
    }
}

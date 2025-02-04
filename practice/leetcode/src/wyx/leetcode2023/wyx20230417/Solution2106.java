/*
 * @Author: Tungbo
 * @Date: 2023-05-04 18:22:38
 * @LastEditTime: 2023-05-04 18:22:42
 * @LastEditors: Tungbo
 * @Description: leecode: 2106. 摘水果
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230417;

public class Solution2106 {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int ans = 0, s = 0;
        for (int i = 0, j = 0; j < fruits.length; ++j) {
            int pj = fruits[j][0], fj = fruits[j][1];
            s += fj;
            while (i <= j && pj - fruits[i][0] + Math.min(Math.abs(startPos - fruits[i][0]), Math.abs(startPos - pj)) > k) {
                s -= fruits[i++][1];
            }
            ans = Math.max(ans, s);
        }
        return ans;
    }
}

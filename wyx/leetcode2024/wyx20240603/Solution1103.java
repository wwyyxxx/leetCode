/*
 * @Author: Tungbo
 * @Date: 2024-06-03 22:13:54
 * @LastEditTime: 2024-06-03 22:13:59
 * @LastEditors: Tungbo
 * @Description: leecode: 1103. 分糖果 II
 */
package wyx.leetcode2024.wyx20240603;

public class Solution1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int cnt = 1, i = 0;
        while(candies > 0) {
            res[i++] += Math.min(cnt, candies);
            i = i % num_people;
            candies -= cnt++;
        }
        return res;
    }
}

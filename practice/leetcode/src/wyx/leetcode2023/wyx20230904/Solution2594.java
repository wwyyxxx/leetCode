/*
 * @Author: Tungbo
 * @Date: 2023-09-07 20:03:59
 * @LastEditTime: 2023-09-07 20:08:31
 * @LastEditors: Tungbo
 * @Description: leecode: 2594. 修车的最少时间
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230904;

public class Solution2594 {
    public long repairCars(int[] ranks, int cars) {
        long l = 1, r = 1l * ranks[0] * cars * cars;
        while (l < r) {
            long m = l + r >> 1;
            if (check(ranks, cars, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public boolean check(int[] ranks, int cars, long m) {
        long cnt = 0;
        for (int x : ranks) {
            cnt += (long) Math.sqrt(m / x);
        }
        return cnt >= cars;
    }
}

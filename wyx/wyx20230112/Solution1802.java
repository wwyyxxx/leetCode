/*
 * @Author: Tungbo
 * @Date: 2023-01-04 17:45:55
 * @LastEditTime: 2023-01-04 19:43:47
 * @LastEditors: Tungbo
 * @Description: leecode: 1802. 有界数组中指定下标处的最大值
 */
package wyx.wyx20230112;

public class Solution1802 {
    public int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (sum(mid - 1, index) + sum(mid, n - index) <= maxSum) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private long sum(long x, int cnt) {
        return x >= cnt ? (x + x - cnt + 1) * cnt / 2 : (x + 1) * x / 2 + cnt - x;
    }
}

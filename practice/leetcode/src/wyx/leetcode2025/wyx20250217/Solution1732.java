/*
 * @Author: Tungbo
 * @Date: 2025-02-20 21:40:03
 * @LastEditTime: 2025-02-20 21:48:55
 * @LastEditors: Tungbo
 * @Description: leecode: 1732. 找到最高海拔
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250217;

public class Solution1732 {
    public int largestAltitude(int[] gain) {
        int res = 0, cur = 0;
        for (int i = 0; i < gain.length; i++) {
            cur = gain[i] + cur;
            res = Math.max(cur, res);
        }
        return res;
    }
}

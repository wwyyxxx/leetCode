/*
 * @Author: Tungbo
 * @Date: 2024-03-28 15:14:22
 * @LastEditTime: 2024-03-28 15:22:30
 * @LastEditors: Tungbo
 * @Description: leecode: 1997. 访问完所有房间的第一天
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240325;

public class Solution1997 {
    
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        final long MOD = 1_000_000_007;
        int n = nextVisit.length;
        long[] s = new long[n];
        for (int i = 0; i < n - 1; i++) {
            int j = nextVisit[i];
            s[i + 1] = (s[i] * 2 - s[j] + 2 + MOD) % MOD;
        }
        return (int)s[n -1];
    }

}

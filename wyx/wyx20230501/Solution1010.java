/*
 * @Author: Tungbo
 * @Date: 2023-05-07 12:12:14
 * @LastEditTime: 2023-05-07 12:21:48
 * @LastEditors: Tungbo
 * @Description: leecode: 1010. 总持续时间可被 60 整除的歌曲
 */
package wyx.wyx20230501;

public class Solution1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] cnt = new int[60];
        int ans = 0;
        for(int t : time) {
            t %= 60;
            int y = (60 - t) % 60;
            ans += cnt[y];
            cnt[t]++;
        }
        return ans;
    }
}

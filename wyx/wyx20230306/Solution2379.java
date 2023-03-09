/*
 * @Author: Tungbo
 * @Date: 2023-03-09 09:59:19
 * @LastEditTime: 2023-03-09 09:59:23
 * @LastEditors: Tungbo
 * @Description: leecode: 2379. 得到 K 个黑块的最少涂色次数
 */
package wyx.wyx20230306;

public class Solution2379 {
    public int minimumRecolors(String blocks, int k) {
        int[] cnt = new int[128];
        char[] cs = blocks.toCharArray();
        int left = 0, ans = cs.length;
        for(int rigth = 0; rigth < cs.length; rigth++) {
            cnt[cs[rigth]]++;
            if(rigth - left + 1 >= k) {
                ans = Math.min(ans,cnt['W']);
                cnt[ cs[left++] ]--;
            }
        }
        return ans;
    }
}

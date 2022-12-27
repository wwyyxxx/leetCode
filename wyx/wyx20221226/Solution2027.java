/*
 * @Author: Tungbo
 * @Date: 2022-12-27 17:06:09
 * @LastEditTime: 2022-12-27 17:59:31
 * @LastEditors: Tungbo
 * @Description: leecode: 2027. 转换字符串的最少操作次数
 */
package wyx.wyx20221226;

public class Solution2027 {
    public int minimumMoves(String s) {
        int ans = 0;
        for (int i = 0; i < s.length();) {
            if(s.charAt(i) == 'X') {
                ans++;
                i+=3;
            } else i++;
        }
        return ans;
    }
}

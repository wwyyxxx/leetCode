/*
 * @Author: Tungbo
 * @Date: 2023-01-08 21:42:22
 * @LastEditTime: 2023-01-08 21:43:28
 * @LastEditors: Tungbo
 * @Description: leecode: 2185. 统计包含给定前缀的字符串
 */
package wyx.wyx20230112;

public class Solution2185 {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String str : words) {
            if(str.indexOf(pref) == 0) ans++;
        }
        return ans;
    }
}

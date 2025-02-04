/*
 * @Author: Tungbo
 * @Date: 2023-04-24 10:42:05
 * @LastEditTime: 2023-04-24 11:16:32
 * @LastEditors: Tungbo
 * @Description: leecode: 1163. 按字典序排在最后的子串
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230424;

public class Solution1163 {

    public String lastSubstring(String s) {
        int n = s.length();
        int i = 0;
        for (int j = 1, k = 0; j + k < n;) {
            int d = s.charAt(i + k) - s.charAt(j + k);
            if(d == 0) {
                ++k;
            } else if(d < 0) {
                i += k + 1;
                k = 0;
                if(i >= j) j = i + 1;
            } else {
                j += k + 1;
                k = 0;
            }
        }
        return s.substring(i);
    }

}

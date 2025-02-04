/*
 * @Author: Tungbo
 * @Date: 2024-03-11 13:49:06
 * @LastEditTime: 2024-03-11 14:16:06
 * @LastEditors: Tungbo
 * @Description: leecode: 2129. 将标题首字母大写
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240311;

public class Solution2129 {
    public String capitalizeTitle(String title) {
        String[] s = title.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() <= 2) {
                s[i] = s[i].toLowerCase();
            } else {
                s[i] = s[i].substring(0,1).toUpperCase() + s[i].substring(1).toLowerCase();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            sb.append(s[i]).append(" ");
        }
        return sb.toString().trim();
    }
}

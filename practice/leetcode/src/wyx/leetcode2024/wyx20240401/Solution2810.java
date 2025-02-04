/*
 * @Author: Tungbo
 * @Date: 2024-04-01 16:33:28
 * @LastEditTime: 2024-04-01 16:34:53
 * @LastEditors: Tungbo
 * @Description: leecode: 2810. 故障键盘
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240401;

public class Solution2810 {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c == 'i') {
                sb.reverse();
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

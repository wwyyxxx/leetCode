/*
 * @Author: Tungbo
 * @Date: 2022-09-26 15:21:52
 * @LastEditTime: 2022-09-26 15:42:02
 * @LastEditors: Tungbo
 * @Description: leecode: 1694. 重新格式化电话号码
 * 
 * 给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。
 * 
 */
package wyx.wyx20220926;

import java.util.Arrays;

public class Solution1694 {
    public String reformatNumber(String number) {
        String s = number.replace(" ", "").replace("-", "");
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i += 3) {
            if (sb.length() != 0) sb.append("-");
            if (i + 5 > n) {
                if (i + 3 >= n) sb.append(s.substring(i));
                else sb.append(s.substring(i, i + 2)).append("-").append(s.substring(i + 2));
                break;
            }
            sb.append(s.substring(i, i + 3));
        }
        return sb.toString();
    }
}

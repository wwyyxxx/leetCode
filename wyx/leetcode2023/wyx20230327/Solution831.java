package wyx.wyx20230327;

/*
 * @Author: Tungbo
 * @Date: 2023-04-01 15:02:14
 * @LastEditTime: 2023-03-28 15:56:40
 * @LastEditors: Tungbo
 * @Description: leecode: 831. 隐藏个人信息
 */
public class Solution831 {
    String[] country = {"", "+*-", "+**-", "+***-"};

    public String maskPII(String s) {
        int at = s.indexOf("@");
        if (at > 0) {
            s = s.toLowerCase();
            return (s.charAt(0) + "*****" + s.substring(at - 1)).toLowerCase();
        }
        s = s.replaceAll("[^0-9]", "");
        return country[s.length() - 10] + "***-***-" + s.substring(s.length() - 4);
    }
}

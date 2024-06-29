package wyx.leetcode2024.wyx20240617;

/*
 * @Author: Tungbo
 * @Date: 2024-06-29 20:43:40
 * @LastEditTime: 2024-06-29 20:43:44
 * @LastEditors: Tungbo
 * @Description: leecode: 2710. 移除字符串中的尾随零
 */
public class Solution2710 { 
    public String removeTrailingZeros(String num) {
        int len = num.length();
        while(len >=0 && num.charAt(len - 1) == '0') {
            len--;
        }
        return num.substring(0, len);
    }
}
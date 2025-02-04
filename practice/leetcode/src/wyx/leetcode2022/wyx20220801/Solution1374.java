/*
 * @Author: Tungbo
 * @Date: 2022-08-01 11:21:22
 * @LastEditTime: 2022-08-01 11:28:57
 * @LastEditors: Tungbo
 * @Description: leecode: 1374. 生成每种字符都是奇数个的字符串
 * 
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220801;

import java.util.Arrays;

public class Solution1374 {
    
    public String generateTheString(int n) {
        char[] chars = new char[n];
        Arrays.fill(chars,'a');
        if(n % 2 == 0) chars[n - 1] = 'b';
        return new String(chars);
    }
}

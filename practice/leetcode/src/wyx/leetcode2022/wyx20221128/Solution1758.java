package practice.leetcode.src.wyx.leetcode2022.wyx20221128;

import java.util.Arrays;

/*
 * @Author: Tungbo
 * @Date: 2022-11-29 10:57:45
 * @LastEditTime: 2022-11-29 11:20:33
 * @LastEditors: Tungbo
 * @Description: leecode: 1758. 生成交替二进制字符串的最少操作数
 * 
 * 给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
 * 返回使 s 变成 交替字符串 所需的 最少 操作数。
 * 
 */
public class Solution1758 {
    public int minOperations(String s) {
        int cnt = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            cnt += (ch[i] != "01".charAt(i & 1) ? 1 : 0);
        }
        return Math.min(cnt, ch.length - cnt);
    }
}

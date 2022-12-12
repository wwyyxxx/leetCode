/*
 * @Author: Tungbo
 * @Date: 2022-12-12 15:27:17
 * @LastEditTime: 2022-12-12 16:14:47
 * @LastEditors: Tungbo
 * @Description: leecode: 1781. 所有子字符串美丽值之和
 * 
 * 一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
 *  比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
 * 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
 *
 */
package wyx.wyx20221212;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1781 {
    public int beautySum(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] cnt = new int[26];
            int max = 0;
            for (int j = i; j < s.length(); j++) {
                cnt[s.charAt(j) - 'a']++;
                max = Math.max(max, cnt[s.charAt(j) - 'a']);
                int min = s.length();
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 0) {
                        min = Math.min(min, cnt[k]);
                    }
                }
                res += max - min;
            }
        }
        return res;
    }

}

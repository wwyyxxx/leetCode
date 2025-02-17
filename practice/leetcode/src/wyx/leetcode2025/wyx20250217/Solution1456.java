/*
 * @Author: Tungbo
 * @Date: 2025-02-17 12:16:28
 * @LastEditTime: 2025-02-17 12:23:37
 * @LastEditors: Tungbo
 * @Description: leecode: 1456. 定长子串中元音的最大数目
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1456 {
    public int maxVowels(String s, int k) {
        int cnt = 0, res = 0;
        Set<Character> dic = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        for (int i = 0; i < s.length(); i++) {
            if (dic.contains(s.charAt(i))) {
                cnt++;
                res = Math.max(res, cnt);
            }
            if (i < k -1) {
                continue;
            }
            if (dic.contains(s.charAt(i- k + 1))) {
                cnt--;
            }
        }
        return res;
    }
}

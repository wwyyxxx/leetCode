/*
 * @Author: Tungbo
 * @Date: 2022-10-30 14:23:23
 * @LastEditTime: 2022-10-30 14:52:18
 * @LastEditors: Tungbo
 * @Description: leecode: 784. 字母大小写全排列
 * 
 * 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221024;

import java.util.ArrayList;
import java.util.List;

public class Solution784 {

    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        dfs(s, 0, new char[s.length()], result);
        return result;
    }

    private void dfs(String s, int i, char[] cur, List<String> result) {
        if (i == s.length()) {
            result.add(new String(cur));
            return;
        }
        cur[i] = s.charAt(i);
        dfs(s, i+1, cur, result);
        if (!Character.isDigit(s.charAt(i))) {
            cur[i] = (char) (s.charAt(i) ^ 32);
            dfs(s, i+1, cur, result);
        }
    }

}

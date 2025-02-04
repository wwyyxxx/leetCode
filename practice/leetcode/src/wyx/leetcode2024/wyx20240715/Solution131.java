/*
 * @Author: Tungbo
 * @Date: 2024-07-19 17:55:16
 * @LastEditTime: 2024-07-23 19:27:35
 * @LastEditors: Tungbo
 * @Description: leecode: 131. 分割回文串
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240715;

import java.util.ArrayList;
import java.util.List;

public class Solution131 {
    
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if (s.length() == 0) {
            return res;
        }
        dfs(0, 0, s, new ArrayList<>());
        return res;
    }
    private void dfs(int i, int start, String s, List<String> path) {
        if (i == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (i < s.length() - 1) {
            dfs(i + 1, start, s, path);
        }

        if (isPalindrome(start, i, s)) {
            path.add(s.substring(start, i + 1));
            dfs(i + 1, i + 1, s, path);
            path.remove(path.size() - 1);
        }
    }
    private boolean isPalindrome(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}

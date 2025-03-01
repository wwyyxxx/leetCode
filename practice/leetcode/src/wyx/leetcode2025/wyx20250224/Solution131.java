/*
 * @Author: Tungbo
 * @Date: 2025-03-01 11:29:04
 * @LastEditTime: 2025-03-01 11:53:04
 * @LastEditors: Tungbo
 * @Description: leecode: 131. 分割回文串
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250224;

import java.util.ArrayList;
import java.util.List;

public class Solution131 {

    List<List<String>> ans = new ArrayList<List<String>>();
    List<String> path = new ArrayList<>();
    String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(i, j)) {
                path.add(s.substring(i, j + 1));
                dfs(j + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

}

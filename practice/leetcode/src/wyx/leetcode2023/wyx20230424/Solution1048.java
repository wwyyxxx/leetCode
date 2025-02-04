/*
 * @Author: Tungbo
 * @Date: 2023-04-27 14:14:42
 * @LastEditTime: 2023-04-27 14:14:45
 * @LastEditors: Tungbo
 * @Description: leecode: 1048. 最长字符串链
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230424;

import java.util.HashMap;
import java.util.Map;

public class Solution1048 {
    private Map<String, Integer> ws = new HashMap<>();

    public int longestStrChain(String[] words) {
        for (String s : words)
            ws.put(s, 0); // 0 表示未被计算
        int ans = 0;
        for (String s : ws.keySet())
            ans = Math.max(ans, dfs(s));
        return ans;
    }

    private int dfs(String s) {
        int res = ws.get(s);
        if (res > 0) return res; // 之前计算过
        for (int i = 0; i < s.length(); i++) { // 枚举去掉 s[i]
            String t = s.substring(0, i) + s.substring(i + 1);
            if (ws.containsKey(t)) // t 在 words 中
                res = Math.max(res, dfs(t));
        }
        ws.put(s, res + 1); // 记忆化
        return res + 1;
    }
}

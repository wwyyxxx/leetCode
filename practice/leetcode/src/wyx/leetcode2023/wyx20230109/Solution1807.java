package practice.leetcode.src.wyx.leetcode2023.wyx20230109;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author: Tungbo
 * @Date: 2023-01-12 16:00:55
 * @LastEditTime: 2023-01-12 17:15:28
 * @LastEditors: Tungbo
 * @Description: leecode: 1807. 替换字符串中的括号内容
 */
public class Solution1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> knowledgeMap = new HashMap<String, String>();
        for (List<String> list : knowledge) {
            // String t = "("+list.get(0)+")";
            // s = s.replace(t, list.get(1));
            knowledgeMap.put(list.get(0), list.get(1));
        }

        int idx = 0, start = 0, end = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                start = i;
            if (s.charAt(i) == ')') {
                end = i;
                String t = s.substring(start+1, end);
                ans.append(s.substring(idx,start));
                ans.append(knowledgeMap.getOrDefault(t, "?"));
                idx = end+1;
            }
        }
        ans.append(s.substring(idx));
        return ans.toString();
    }
}

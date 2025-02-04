/*
 * @Author: Tungbo
 * @Date: 2024-07-17 16:16:47
 * @LastEditTime: 2024-07-17 16:31:23
 * @LastEditors: Tungbo
 * @Description: leecode: 17. 电话号码的字母组合
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240715;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution17 {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrackPhone(0, digits, phoneMap, res, new StringBuilder());
        return res;
    }

    private void backtrackPhone(int idx, String digits, Map<Character, String> phoneMap, List<String> res,
            StringBuilder sb) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String str = phoneMap.get(digits.charAt(idx));
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backtrackPhone(idx + 1, digits, phoneMap, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    
}

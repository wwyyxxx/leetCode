/*
 * @Author: Tungbo
 * @Date: 2024-07-28 17:41:50
 * @LastEditTime: 2024-07-28 18:02:23
 * @LastEditors: Tungbo
 * @Description: leecode: 20. 有效的括号
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240722;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class Solution20 {


    public boolean isValid(String s) {
        Map<Character, Character> dic = new HashMap<>(){{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        int len = s.length();
        Stack<Character> q = new Stack<>(); 
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (q.isEmpty() || q.peek() != dic.get(c)) {
                q.add(c);
            } else {
                q.pop();
            }
        }
        return q.isEmpty();
    }
}

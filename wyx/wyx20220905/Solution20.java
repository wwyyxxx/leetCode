/*
 * @Author: Tungbo
 * @Date: 2022-09-06 12:22:08
 * @LastEditTime: 2022-09-06 13:32:41
 * @LastEditors: Tungbo
 * @Description: leecode: 20. 有效的括号
 * 
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效
 * 有效字符串需满足
 * 
 */
package wyx.wyx20220905;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution20 {
    
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        HashMap<Character, Character> dic = new HashMap<Character, Character>();
        dic.put('(', ')');
        dic.put('[', ']');
        dic.put('{', '}');
        if(s.length() > 0 && !dic.containsKey(s.charAt(0))) return false;
        for (Character c : s.toCharArray()) {
            if(dic.containsKey(c)) {
                stack.addLast(c);
            } else {
                if(stack.isEmpty() || dic.get(stack.removeLast()) != c) return false;
            }
        }
        return stack.isEmpty();
    }

}

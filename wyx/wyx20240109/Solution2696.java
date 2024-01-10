/*
 * @Author: Tungbo
 * @Date: 2024-01-10 16:07:27
 * @LastEditTime: 2024-01-10 16:07:29
 * @LastEditors: Tungbo
 * @Description: leecode: 2696. 删除子串后的字符串最小长度
 */
package wyx.wyx20240109;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2696 {
    public int minLength(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        stk.push(' ');
        for(char c : s.toCharArray()) {
            if(c == 'B' && stk.peek() == 'A' || c == 'D' && stk.peek() == 'C') {
                stk.pop();
            } else {
                stk.push(c);
            }
        }
        return stk.size() -1;
    } 
    
    public int minLength1(String s) {
        String s1 = "AB", s2 = "CD";
        while(s.contains(s1) || s.contains(s2)) {
            s = s.replaceAll(s1,"");
            s = s.replaceAll(s2,"");
        }
        return s.length();
    } 
}

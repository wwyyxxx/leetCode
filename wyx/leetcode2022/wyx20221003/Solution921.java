package wyx.wyx20221003;

import java.util.LinkedList;

/*
 * @Author: Tungbo
 * @Date: 2022-10-04 15:21:52
 * @LastEditTime: 2022-10-04 15:42:02
 * @LastEditors: Tungbo
 * @Description: leecode: 921. 使括号有效的最少添加
 * 
 * 给定一个括号字符串 s ，移动N次，你就可以在字符串的任何位置插入一个括号。
 * 返回 为使结果字符串 s 有效而必须添加的最少括号数。
 */
public class Solution921 {
    public int minAddToMakeValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if(c == ')' && !stack.isEmpty()) {
                if(stack.peek() == '(') stack.pop();
                else stack.push(c);
            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }
}

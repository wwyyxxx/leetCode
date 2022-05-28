/*
 * @Author: Tungbo
 * @Date: 2022-05-28 20:36:40
 * @LastEditTime: 2022-05-28 20:48:28
 * @LastEditors: Tungbo
 * @Description: leecode: 1021. 删除最外层的括号
 * 
 * 有效括号字符串为空 ""、"(" + A + ")" 或 A + B ，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
 * 如果有效字符串 s 非空，且不存在将其拆分为 s = A + B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * 给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * 对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。
 * 
 * 
 */
package wyx.wyx20220523;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Soluton1021 {
    
    public static void main(String[] args) {
        System.out.println(new Soluton1021().removeOuterParentheses("(()())(())"));
    }

    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] ch = s.toCharArray();
        List<String> list = new ArrayList<>();
        int idx = 0;
        for(int i = 0; i < ch.length; i++){
            if(ch[i] =='(') {
                stack.add(ch[i]);
            } else {
                stack.pop();
            }
            //栈为空时，刚好匹配括号字符串。截取
            if(stack.isEmpty() && i != 0) {
                list.add(s.substring(idx,i+1));
                idx = i+1;
            }
        }
        StringBuffer strb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            String temp = list.get(i);
            //如果不是自由一个括号的话，则截断前后字符
            if(temp.charAt(1) != ')') {
                strb.append(temp.substring(1,temp.length()-1));
            }
        }
        return strb.toString();
    }
}

/*
 * @Author: Tungbo
 * @Date: 2022-10-09 11:20:56
 * @LastEditTime: 2022-10-09 11:32:25
 * @LastEditors: Tungbo
 * @Description: leecode: 856. 括号的分数
 * 
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 *  () 得 1 分。
 *  AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 *  (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221003;

import java.util.LinkedList;

public class Solution856 {

    public int scoreOfParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.push(0);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(0);
            } else {
                int x = stack.poll();
                int val = stack.poll() + Math.max(2 * x, 1);
                stack.push(val);
            }
        }
        return stack.poll();
    }

}

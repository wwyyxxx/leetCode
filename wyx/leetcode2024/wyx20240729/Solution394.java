/*
 * @Author: Tungbo
 * @Date: 2024-07-29 17:21:33
 * @LastEditTime: 2024-07-30 15:45:19
 * @LastEditors: Tungbo
 * @Description: leecode: 394. 字符串解码
 */
package wyx.leetcode2024.wyx20240729;

import java.util.Stack;

public class Solution394 {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int muilt = 0;
        StringBuilder res = new StringBuilder();
        for(char c : s.toCharArray()) {
            if (c == '[') {
                numStack.push(muilt);
                resStack.push(res.toString());
                muilt = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                int num = numStack.pop();
                for (int i = 0; i < num; i++) {
                    temp.append(res.toString());
                }
                res = new StringBuilder(resStack.pop() + temp.toString());
            } else if (c >= '0' && c <= '9') {
                muilt = muilt*10 + (c - '0');
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}

/*
 * @Author: Tungbo
 * @Date: 2022-11-05 15:38:44
 * @LastEditTime: 2022-11-05 17:28:32
 * @LastEditors: Tungbo
 * @Description: leecode: 1106. 解析布尔表达式
 * 
 * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果
 * 有效的表达式需遵循以下约定
 *  t"，运算结果为 True
 *  "f"，运算结果为 False
 *  "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 *  "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式expr1, expr2, ... 进行逻辑 与的运算（AND）
 *  "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 * 
 */
package wyx.wyx20221031;

import java.util.Deque;
import java.util.LinkedList;

public class Solution1106 {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> stack = new LinkedList<Character>();
        char[] expr = expression.toCharArray();
        for (int i = 0; i < expr.length; i++) {
            char c = expr[i];
            if (c == ',')
                continue;
            else if (c != ')')
                stack.push(expr[i]);
            else {
                int t = 0, f = 0;
                while (stack.peek() != '(') {
                    char val = stack.pop();
                    if (val == 't')
                        t++;
                    else
                        f++;
                }
                stack.pop();
                char op = stack.pop();
                switch (op) {
                    case '!':
                        stack.push(f == 1 ? 't' : 'f');
                        break;
                    case '&':
                        stack.push(f == 0 ? 't' : 'f');
                        break;
                    case '|':
                        stack.push(t > 0 ? 't' : 'f');
                        break;
                    default:
                }
            }
        }
        return stack.peek() == 't';
    }
}

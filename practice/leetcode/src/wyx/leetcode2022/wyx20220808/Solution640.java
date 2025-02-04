/*
 * @Author: Tungbo
 * @Date: 2022-08-10 11:14:48
 * @LastEditTime: 2022-08-10 11:30:13
 * @LastEditors: Tungbo
 * @Description: leecode: 640. 求解方程
 * 
 * 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数
 * 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions”
 * 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220808;

public class Solution640 {
    
    public String solveEquation(String equation) {
        int factor = 0, val = 0;
        int index = 0, n = equation.length(), sign1 = 1;
        while (index < n) {
            if(equation.charAt(index) == '=') {
                sign1 = -1;
                index++; 
                continue;
            }
            int sign2 = sign1, number = 0;
            boolean valid = false;
            if(equation.charAt(index) == '-' || equation.charAt(index) == '+') {
                sign2 = equation.charAt(index) == '-' ? -sign1 : sign1;
                index++;
            }
            while(index < n && Character.isDigit(equation.charAt(index))) {
                number = number * 10 + equation.charAt(index) - '0';
                index++;
                valid = true;
            }
            if(index < n && equation.charAt(index) == 'x') {
                factor += valid ? sign2 * number : sign2;
                index++;
            } else {
                val += sign2 * number;
            }
        }
        if(factor == 0) {
            return val == 0 ? "Infinite solutions" : "No solution";
        }
        return "x=" + (-val / factor);
    }

}

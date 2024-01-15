/*
 * @Author: Tungbo
 * @Date: 2022-07-27 15:58:40
 * @LastEditTime: 2022-07-27 16:24:38
 * @LastEditors: Tungbo
 * @Description: leecode: 592. 分数加减运算
 * 
 * 给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果
 * 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1
 * 
 */
package wyx.wyx20220725;

public class Solurtion529 {


    public String fractionAddition(String expression) {
        long denominator = 0, numerator = 1;
        int index = 0, n = expression.length();
        while(index < n) {
            long denominator1 = 0, sign = 1;
            if(expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                sign = expression.charAt(index) == '-' ? -1 : 1;
                index++;
            }
            while(index < n && Character.isDigit(expression.charAt(index))) {
                denominator1 = denominator1 * 10 + expression.charAt(index) - '0';
                index++;
            }
            denominator1 = sign * denominator1;
            index++;

            long numerator1 = 0;
            while(index < n && Character.isDigit(expression.charAt(index))) {
                numerator1 = numerator1 * 10 + expression.charAt(index) - '0';
                index++;
            }

            denominator = denominator * numerator1 + denominator1 * numerator;
            numerator *= numerator1;
        }
        if(denominator == 0) {
            return "0/1";
        }
        long g = gcd(Math.abs(denominator),numerator);
        return Long.toString(denominator/g) + "/" + Long.toString(numerator/g);
    }

    private long gcd(long a, long b) {
        long remainder = a % b;
        while(remainder != 0) {
            a =b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }


}

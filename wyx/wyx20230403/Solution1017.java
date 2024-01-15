/*
 * @Author: Tungbo
 * @Date: 2023-04-06 10:43:33
 * @LastEditTime: 2023-04-06 11:26:19
 * @LastEditors: Tungbo
 * @Description: leecode: 1017. 负二进制转换
 */
package wyx.wyx20230403;

public class Solution1017 {
    public String baseNeg2(int n) {
        if(n == 0 || n == 1) return String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        while(n != 0) {
            int remainder = n & 1;
            sb.append(remainder);
            n -= remainder;
            n /= -2;
        }
        return sb.reverse().toString();
    }
}

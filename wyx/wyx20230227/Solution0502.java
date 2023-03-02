/*
 * @Author: Tungbo
 * @Date: 2023-03-02 12:00:13
 * @LastEditTime: 2023-03-02 12:00:17
 * @LastEditors: Tungbo
 * @Description: leecode: 面试题 05.02. 二进制数转字符串
 */
package wyx.wyx20230227;

public class Solution0502 {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        while(num > 0) {
            if(sb.length() >= 32) return "ERROR";
            num *= 2;
            if(num >= 1) {
                sb.append("1");
                num -=1;
            } else {
                sb.append("0");
            }
        }
        return sb.toString();
    }
}

package practice.leetcode.src.wyx.leetcode2025.wyx0311;
/*
 * @Author: Tungbo
 * @Date: 2025-03-16 21:51:48
 * @LastEditTime: 2025-03-16 21:06:45
 * @LastEditors: Tungbo
 * @Description: leecode: 3340. 检查平衡字符串
 */
public class Solution3340 {
    public boolean isBalanced(String num) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < num.length(); i++) {
            if (i % 2 ==0) {
                sum1 += num.charAt(i) - '0';
            } else {
                sum2 += num.charAt(i) - '0';
            }
        }
        return sum1 == sum2;
    }
}

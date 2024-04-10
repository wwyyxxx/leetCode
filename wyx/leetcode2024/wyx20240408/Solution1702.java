/*
 * @Author: Tungbo
 * @Date: 2024-04-10 10:28:29
 * @LastEditTime: 2024-04-10 10:35:04
 * @LastEditors: Tungbo
 * @Description: leecode: 1702. 修改后的最大二进制字符串
 */
package wyx.leetcode2024.wyx20240408;

public class Solution1702 {
    public String maximumBinaryString(String binary) {
        int i = binary.indexOf('0');
        if (i < 0) { // binary 全是 '1'
            return binary;
        }
        char[] s = binary.toCharArray();
        int cnt1 = 0;
        for (i++; i < s.length; i++) {
            cnt1 += s[i] - '0'; // 统计 [i, n-1] 中 '1' 的个数
        }
        return "1".repeat(s.length - 1 - cnt1) + '0' + "1".repeat(cnt1);
    }
}

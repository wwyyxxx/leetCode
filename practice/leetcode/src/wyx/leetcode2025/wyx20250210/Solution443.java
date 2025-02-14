/*
 * @Author: Tungbo
 * @Date: 2025-02-13 12:18:02
 * @LastEditTime: 2025-02-14 23:14:36
 * @LastEditors: Tungbo
 * @Description: leecode: 443. 压缩字符串
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250210;

public class Solution443 {
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}

/*
 * @Author: Tungbo
 * @Date: 2025-03-17 22:36:41
 * @LastEditTime: 2025-03-17 22:49:42
 * @LastEditors: Tungbo
 * @Description: leecode: 1963. 使字符串平衡的最小交换次数
 */
package practice.leetcode.src.wyx.leetcode2025.wyx0311;

public class Solution1963 {
    public int minSwaps1(String S) {
        char[] s = S.toCharArray();
        int ans = 0;
        int c = 0, j = S.length() -1;
        for(char b : s) {
            if(b == '[') {
                c++;
            } else if (c > 0) {
                c--;
            } else {
                while (s[j] == ']') {
                    j--;
                }
                s[j] = ']';
                ans++;
                c++;
            }
        }
        return ans;
    }

    public int minSwaps2(String S) {
        char[] s = S.toCharArray();
        int ans = 0;
        int c = 0;
        for(char b : s) {
            if(b == '[') {
                c++;
            } else if (c > 0) {
                c--;
            } else {
                ans++;
                c++;
            }
        }
        return ans;
    }
}

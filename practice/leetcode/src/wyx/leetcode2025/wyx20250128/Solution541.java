package practice.leetcode.src.wyx.leetcode2025.wyx20250128;

/*
 * @Author: Tungbo
 * @Date: 2025-01-31 01:36:44
 * @LastEditTime: 2025-01-31 01:49:31
 * @LastEditors: Tungbo
 * @Description: leecode: 541. 反转字符串 II
 */
public class Solution541 {

    char[] tempDatas;

    public String reverseStr(String s, int k) {
        tempDatas = s.toCharArray();
        int n = s.length();

        int start = 0, end = k - 1;
        while (start < n) {
            reverse(start, end < n - 1 ? end : n - 1);
            start += 2 * k;
            end = start + k - 1;
        }
        return new String(tempDatas);
    }

    private void reverse(int start, int end) {
        while (start < end) {
            char temp = tempDatas[start];
            tempDatas[start] = tempDatas[end];
            tempDatas[end] = temp;
            start++;
            end--;
        }
    }
}

/*
 * @Author: Tungbo
 * @Date: 2024-05-05 17:27:16
 * @LastEditTime: 2024-05-05 17:27:21
 * @LastEditors: Tungbo
 * @Description: leecode: 1652. 拆炸弹
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240428;

public class Solution1652 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if(n == 0) return code;
        for(int i = 0; i < n; i++) {
            if(k > 0) {
                for(int j = i + 1; j < k + i + 1; j++) {
                    ans[i] += code[j % n];
                }
            } else if ( k < 0) {
                for(int j = i + k; j < i; j++) {
                    ans[i] += code[(j + n) % n];
                }
            } else {
                ans[i] = 0;
            }
        }
        return ans;
    }
}

/*
 * @Author: Tungbo
 * @Date: 2022-09-24 19:17:45
 * @LastEditTime: 2022-09-24 19:42:31
 * @LastEditors: Tungbo
 * @Description: leecode: 1652. 拆炸弹
 * 
 * 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换
 * 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
 * 如果 k == 0 ，将第 i 个数字用 0 替换。
 * 
 */
package wyx.wyx20220912;

public class Solution1652 {

    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        int n = Math.abs(k);
        for (int i = 0; i < code.length; i++) {
            if (k > 0) {
                for (int j = 1; j <= n; j++) {
                    int m = (i + j) % code.length;
                    ans[i] += code[m];
                }
            }
            if (k < 0) {
                for (int j = 1; j <= n; j++) {
                    int m = i - j < 0 ? code.length + i -j : i -j;
                    ans[i] += code[m];
                }
            }
        }
        return ans;
    }

}

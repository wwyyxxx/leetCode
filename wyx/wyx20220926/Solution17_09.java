/*
 * @Author: Tungbo
 * @Date: 2022-09-28 14:45:59
 * @LastEditTime: 2022-09-28 15:28:43
 * @LastEditors: Tungbo
 * @Description: leecode: 面试题 17.09. 第 k 个数
 * 
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。
 * 例如，前几个数按顺序应该是 1，3，5，7，9，15，21
 * 
 */
package wyx.wyx20220926;

public class Solution17_09 {

    public int getKthMagicNumber(int k) {
        int[] ans = new int[k + 1];
        ans[1] = 1;
        for (int i3 = 1, i5 = 1, i7 = 1, i = 2; i <= k; i++) {
            int a = ans[i3] * 3, b = ans[i5] * 5, c = ans[i7] * 7;
            int min = Math.min(a, Math.min(b, c));
            if(a == min) i3++;
            if(b == min) i5++;
            if(c == min) i7++;
            ans[i] = min;
        }
        return ans[k];
    }
}

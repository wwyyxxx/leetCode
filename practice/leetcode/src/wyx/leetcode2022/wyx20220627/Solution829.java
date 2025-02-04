/*
 * @Author: Tungbo
 * @Date: 2022-06-30 17:02:29
 * @LastEditTime: 2022-06-30 17:09:07
 * @LastEditors: Tungbo
 * @Description: leecode: 829. 连续整数求和
 * 
 * 给定一个正整数 n，返回 连续正整数满足所有数字之和为 n 的组数 。 
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220627;

public class Solution829 {

    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        n *= 2;
        for (int k = 1; k * k < n; k++) {
            if (n % k != 0) continue;
            if ((n / k - (k - 1)) % 2 == 0) ans++;
        }
        return ans;
    }

}

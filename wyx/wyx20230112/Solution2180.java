/*
 * @Author: Tungbo
 * @Date: 2023-01-06 16:34:26
 * @LastEditTime: 2023-01-06 16:47:46
 * @LastEditors: Tungbo
 * @Description: leecode: 2180. 统计各位数字之和为偶数的整数个数
 * 
 * 给你一个正整数 num ，请你统计并返回 小于或等于 num 且各位数字之和为 偶数 的正整数的数目。
 * 正整数的 各位数字之和 是其所有位上的对应数字相加的结果
 * 
 */
package wyx.wyx20230112;

public class Solution2180 {
    public int countEven(int num) {
        int ans = 0;
        for (int i = 1; i <= num; i++) {
            int cur = i, sum = 0;
            while(cur > 0){
                sum += cur%10;
                cur /= 10;
            }
            if(sum%2 == 0) ans++;
        }
        return ans;
    }
}

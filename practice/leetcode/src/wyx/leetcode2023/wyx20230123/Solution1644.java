/*
 * @Author: Tungbo
 * @Date: 2023-01-28 10:52:57
 * @LastEditTime: 2023-01-28 11:50:42
 * @LastEditors: Tungbo
 * @Description: leecode: 1664. 生成平衡数组的方案数
 * 
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230123;

public class Solution1644 {
    public int waysToMakeFair(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0)
                sum2 += nums[i];
            else
                sum1 += nums[i];
        }
        int ans = 0;
        int t1 = 0, t2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (i % 2 == 1)
                ans += sum1 - cur - t1 + t2 == sum2 - t2 + t1 ? 1 : 0;
            else
                ans += sum2 - cur - t2 + t1 == sum1 - t1 + t2 ? 1 : 0;
            t1 += i % 2 == 1 ? cur : 0;
            t2 += i % 2 == 0 ? cur : 0;
        }
        return ans;
    }
}

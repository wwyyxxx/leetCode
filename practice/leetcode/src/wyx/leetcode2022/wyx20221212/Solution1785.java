/*
 * @Author: Tungbo
 * @Date: 2022-12-16 20:26:51
 * @LastEditTime: 2022-12-16 20:26:54
 * @LastEditors: Tungbo
 * @Description: leecode: [1785] 构成特定和需要添加的最少元素
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221212;

public class Solution1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        long diff = Math.abs(sum - goal);
        // int ans = 0;
        // while (diff > 0) {
        //     diff -= limit;
        //     ans++;
        // }
        //(diff+limit-1)/limit
        return (int)Math.ceil((double)diff/limit);
    }
}

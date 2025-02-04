/*
 * @Author: Tungbo
 * @Date: 2024-04-09 10:59:20
 * @LastEditTime: 2024-04-09 10:59:23
 * @LastEditors: Tungbo
 * @Description: leecode: 2529. 正整数和负整数的最大计数
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240408;

public class Solution2529 {
    public int maximumCount(int[] nums) {
        int pos = 0, neg = 0;
        for(int num : nums) {
            if(num < 0) neg++;
            if(num > 0) pos++;
        }
        return Math.max(neg, pos);
    }
}

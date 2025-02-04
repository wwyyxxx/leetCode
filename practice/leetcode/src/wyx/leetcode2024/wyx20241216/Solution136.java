/*
 * @Author: Tungbo
 * @Date: 2024-12-16 22:40:56
 * @LastEditTime: 2024-12-16 22:50:56
 * @LastEditors: Tungbo
 * @Description: leecode: 136. 只出现一次的数字
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20241216;

public class Solution136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums) {
            res ^= num;
        }
        return res;
    }
}

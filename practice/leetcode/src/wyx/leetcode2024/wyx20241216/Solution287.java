/*
 * @Author: Tungbo
 * @Date: 2024-12-19 20:36:05
 * @LastEditTime: 2024-12-19 20:36:07
 * @LastEditors: Tungbo
 * @Description: leecode: 287. 寻找重复数
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20241216;

public class Solution287 {
    public int findDuplicate(int[] nums) {
        int solw = 0, fast = 0;
        do {
            solw = nums[solw];
            fast = nums[nums[fast]];
        } while (solw != fast);
        solw = 0;
        while (solw != fast) {
            solw = nums[solw];
            fast = nums[fast];
        }
        return solw;
    }
}

/*
 * @Author: Tungbo
 * @Date: 2024-08-04 17:29:22
 * @LastEditTime: 2024-08-04 17:31:33
 * @LastEditors: Tungbo
 * @Description: leecode: 55. 跳跃游戏
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240729;

public class Solution55 {
    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k < i) {
                return false;
            }
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }
}

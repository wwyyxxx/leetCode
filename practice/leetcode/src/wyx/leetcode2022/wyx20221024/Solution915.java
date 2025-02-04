/*
 * @Author: Tungbo
 * @Date: 2022-10-24 15:34:00
 * @LastEditTime: 2022-10-24 16:18:38
 * @LastEditors: Tungbo
 * @Description: leecode: 915. 分割数组
 * 
 * 给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得
 *  left 中的每个元素都小于或等于 right 中的每个元素。
 *  left 和 right 都是非空的。
 *  left 的长度要尽可能小。
 * 在完成这样的分组后返回 left 的 长度 。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221024;

public class Solution915 {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] mins = new int[n];
        mins[n -1] = nums[n-1];
        for (int i = n-2; i >= 0 ; i--) {
            mins[i] = Math.min(mins[i+1], nums[i]);
        }
        int max = 0;
        for (int i = 0; i < n -1; i++) {
            max = Math.max(max, nums[i]);
            if(max <= mins[i+1]) return i + 1;
        }
        return -1;
    }
}

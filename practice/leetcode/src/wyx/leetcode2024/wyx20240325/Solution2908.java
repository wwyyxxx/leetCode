/*
 * @Author: Tungbo
 * @Date: 2024-03-29 10:37:19
 * @LastEditTime: 2024-03-29 10:37:21
 * @LastEditors: Tungbo
 * @Description: leecode: 2908. 元素和最小的山形三元组 I
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240325;

public class Solution2908 {
    public int minimumSum(int[] nums) {
        int res = 1000;
        for(int i = 1; i < nums.length - 1; i++) {
            int mid = nums[i];
            int left = 1000, right = 1000;;
            for(int j = i - 1; j >=0 ; j--) {
                if(nums[j] < mid) left = Math.min(left, nums[j]); 
            }
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] < mid) right = Math.min(right, nums[j]); 
            }
            res = Math.min(res, mid + left + right);
        }
        return res < 1000 ? res : -1;
    }
}

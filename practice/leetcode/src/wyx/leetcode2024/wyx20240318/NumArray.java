/*
 * @Author: Tungbo
 * @Date: 2024-03-18 14:28:44
 * @LastEditTime: 2024-03-18 14:48:16
 * @LastEditors: Tungbo
 * @Description: leecode: 303. 区域和检索 - 数组不可变
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240318;

import java.util.Arrays;

public class NumArray {

    long[] preSum;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        if (n == 0) {
            return;
        }
        preSum = new long[n];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        System.out.println(Arrays.toString(preSum));
    }
    
    public int sumRange(int left, int right) {
        if(left > right || left >= n || right >= n) return -1;
        int leftIdx = left - 1 < 0 ? 0 : left - 1;
        int rightIdx = right + 1 >= n ? n - 1 : right + 1;
        System.out.println("leftIdx:" + leftIdx + ",rightIdx:" + rightIdx);
        if(left == 0) return (int)preSum[right];
        if(right == n -1) return (int)(preSum[right] - preSum[left]);
        return (int)(preSum[rightIdx] - preSum[leftIdx - 1]);
    }
}

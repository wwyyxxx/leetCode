/*
 * @Author: Tungbo
 * @Date: 2022-09-20 14:55:48
 * @LastEditTime: 2022-09-20 15:43:58
 * @LastEditors: Tungbo
 * @Description: leecode: 698. 划分为k个相等的子集
 * 
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * 
 */
package wyx.wyx20220919;

import java.util.Arrays;

public class Solution698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int target = sum / k;
        if (sum % k != 0 || nums[nums.length - 1] > target)
            return false;
        int[] buckets = new int[k];
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return dfs(nums, buckets, target, 0);
    }

    private boolean dfs(int[] nums, int[] buckets, int target, int i) {
        if (i == nums.length)
            return true;
        for (int j = 0; j < buckets.length; j++) {
            if (j > 0 && buckets[j] == buckets[j - 1])
                continue;
            if (buckets[i] + nums[j] > target)
                break;
            buckets[j] += nums[i];
            if (dfs(nums, buckets, target, i + 1))
                return true;
            buckets[j] -= nums[i];
        }
        return false;
    }

}

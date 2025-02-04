/*
 * @Author: Tungbo
 * @Date: 2022-08-04 14:41:35
 * @LastEditTime: 2022-08-04 14:54:21
 * @LastEditors: Tungbo
 * @Description: leecode: 1403. 非递增顺序的最小子序列
 * 
 * 给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220801;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1403 {

    public List<Integer> minSubsequence(int[] nums) {
        int maxSum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<Integer>();
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum+=nums[i];
            result.add(nums[i]);
            if(maxSum - sum < sum) break;
        }
        return result;
    }
    
}

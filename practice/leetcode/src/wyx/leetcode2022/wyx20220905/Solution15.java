/*
 * @Author: Tungbo
 * @Date: 2022-09-06 14:39:37
 * @LastEditTime: 2022-09-06 14:51:46
 * @LastEditors: Tungbo
 * @Description: leecode: 15. 三数之和
 * 
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组
 * 注意：答案中不可以包含重复的三元组
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220905;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int k = i + 1, j = nums.length - 1;
            while (k < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    while (k < j && nums[k] == nums[++k])
                        ;
                } else if (sum > 0) {
                    while (k < j && nums[j] == nums[--j])
                        ;
                } else {
                    res.add(Arrays.asList(nums[i], nums[k], nums[j]));
                    while (k < j && nums[k] == nums[++k])
                        ;
                    while (k < j && nums[j] == nums[--j])
                        ;
                }
            }
        }
        return res;
    }

}

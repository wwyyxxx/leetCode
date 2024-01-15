/*
 * @Author: Tungbo
 * @Date: 2022-06-16 10:58:11
 * @LastEditTime: 2022-06-16 11:13:26
 * @LastEditors: Tungbo
 * @Description: leecode: 532. 数组中的 k-diff 数对
 * 
 * 给定一个整数数组和一个整数 k，你需要在数组里找到 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
 * 这里将 k-diff 数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件：
 * 
 * 0 <= i < j < nums.length
 * |nums[i] - nums[j]| == k
 * 
 */
package wyx.wyx20220613;

import java.util.Arrays;

public class Solution532 {
    
    public int findPairs(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i!=0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] - nums[i] == k) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

}

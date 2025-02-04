package practice.leetcode.src.wyx.leetcode2022.wyx20220523;

import java.util.HashMap;
import java.util.Map;

/*
 * @Author: Tungbo
 * @Date: 2022-05-25 16:14:56
 * @LastEditTime: 2022-05-26 21:57:56
 * @LastEditors: Tungbo
 * @Description: leecode: 560. 和为 K 的子数组
 * 
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 
 */
public class Solution560 {

    public int subarraySum1(int[] nums, int k) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum == k) {
                    ans++;
                    // break;  存在负数
                }
            }
        }
        return ans;
    }

    //前缀和
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        //key：前缀和， value: 个数
        Map<Integer,Integer> map = new HashMap<>();
        int pre = 0;

        //初始化前缀和的值
        map.put(0,1);

        for(int i = 0; i < nums.length; i++) {
            
            pre += nums[i];
            
            if(map.containsKey(pre - k)) {
                ans += map.get(pre - k);
            }
            
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return ans;
    }
}
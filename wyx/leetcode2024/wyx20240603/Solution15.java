/*
 * @Author: Tungbo
 * @Date: 2024-06-09 17:11:41
 * @LastEditTime: 2024-06-09 17:36:59
 * @LastEditors: Tungbo
 * @Description: leecode: 15. 三数之和
 */
package wyx.leetcode2024.wyx20240603;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> dic = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            dic.put(0 - nums[i],i);
        }
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = nums[i] + nums[j];
                if(dic.containsKey(temp) && i != dic.get(temp) && j != dic.get(temp)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[dic.get(temp)]);
                    Collections.sort(list);
                    res.add(list);
                }
            }
        }
        return new ArrayList<>(res);
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int k = 0; k < nums.length - 2; k++) {
            if(nums[k] > 0) break;
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum > 0) {
                    while (i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]);
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }
}

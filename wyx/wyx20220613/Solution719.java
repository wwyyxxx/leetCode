/*
 * @Author: Tungbo
 * @Date: 2022-06-15 15:16:25
 * @LastEditTime: 2022-06-16 15:52:15
 * @LastEditors: Tungbo
 * @Description: leecode: 719. 找出第 K 小的数对距离
 * 
 * 数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
 * 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。返回 所有数对距离中 第 k 小的数对距离。
 * 
 */
package wyx.wyx20220613;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution719 {

    public static void main(String[] args) {
        System.out.println(new Solution719().smallestDistancePair(new int[]{1,6,1},3));
    }

    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                list.add(Math.abs(nums[i] - nums[j]));
            }
        }
        Collections.sort(list);
        return list.get(k-1);
    }
    
    public int smallestDistancePair1(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = (int)1e6;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(nums, mid) >= k) r = mid;
            else l = mid + 1;
        }
        return r;
    }
    int check(int[] nums, int x) {
        int n = nums.length, ans = 0;
        for (int i = 0, j = 1; i < n; i++) {
            while (j < n && nums[j] - nums[i] <= x) j++;
            ans += j - i - 1;
        }
        return ans;
    }

}

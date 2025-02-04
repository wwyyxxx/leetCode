/*
 * @Author: Tungbo
 * @Date: 2022-11-14 11:28:49
 * @LastEditTime: 2022-11-14 15:32:02
 * @LastEditors: Tungbo
 * @Description: leecode: 805. 数组的均值分割
 * 
 * 给定你一个整数数组 nums
 * 我们要将 nums 数组中的每个元素移动到 A 数组 或者 B 数组中，使得 A 数组和 B 数组不为空，并且 average(A) == average(B)
 * 如果可以完成则返回true ， 否则返回 false  
 * 注意：对于数组 arr ,  average(arr) 是 arr 的所有元素除以 arr 长度的和
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221114;

import java.util.HashSet;
import java.util.Set;

public class Solution805 {

    public boolean splitArraySameAverage(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        int n = nums.length, m = n / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * n - sum;
        }

        Set<Integer> left = new HashSet<Integer>();
        for (int i = 1; i < (1 << m); i++) {
            int tot = 0;
            for (int j = 0; j < m; j++) {
                if ((i & (1 << j)) != 0) {
                    tot += nums[j];
                }
            }
            if (tot == 0) {
                return true;
            }
            left.add(tot);
        }
        int rsum = 0;
        for (int i = m; i < n; i++) {
            rsum += nums[i];
        }
        for (int i = 1; i < (1 << (n - m)); i++) {
            int tot = 0;
            for (int j = m; j < n; j++) {
                if ((i & (1 << (j - m))) != 0) {
                    tot += nums[j];
                }
            }
            if (tot == 0 || (rsum != tot && left.contains(-tot))) {
                return true;
            }
        }
        return false;
    }

}

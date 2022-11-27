/*
 * @Author: Tungbo
 * @Date: 2022-11-27 14:03:25
 * @LastEditTime: 2022-11-27 14:28:56
 * @LastEditors: Tungbo
 * @Description: leecode: 1752. 检查数组是否经排序和轮转得到
 * 
 * 给你一个数组 nums 。nums 的源数组中，所有元素与 nums 相同，但按非递减顺序排列。
 * 如果 nums 能够由源数组轮转若干位置（包括 0 个位置）得到，则返回 true ；否则，返回 false 。
 * 源数组中可能存在 重复项 。
 * 注意：我们称数组 A 在轮转 x 个位置后得到长度相同的数组 B ，当它们满足 A[i] == B[(i+x) % A.length] ，其中 % 为取余运算
 * 
 */
package wyx.wyx20221121;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1752 {
    public boolean check(int[] nums) {
        int n = nums.length;
        int[] src = Arrays.copyOf(nums, n);
        Arrays.sort(src);
        List<Integer> indexs = new ArrayList<Integer>();
        for (int j = 0; j < n; j++) {
            if (src[0] == nums[j])
                indexs.add(j);
        }
        for (int i = 0; i < indexs.size(); i++) {
            int index = indexs.get(i);
            Boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (nums[(j + index) % n] != src[j]) {
                    flag = false;
                    break;
                }
            }
            if(flag) return flag;
        }
        return false;
    }

    public boolean check1(int[] nums) {
        int count = 0, n = nums.length;
        for (int i = 1; i < nums.length; i++) {
            if(count > 1) return false;
            if(nums[i-1] > nums[i]) count++;
        }
        return count == 0 || (count == 1 && nums[0] >= nums[n-1]);
    }
}

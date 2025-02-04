/*
 * @Author: Tungbo
 * @Date: 2024-06-19 19:45:14
 * @LastEditTime: 2024-06-19 19:51:48
 * @LastEditors: Tungbo
 * @Description: leecode: 41. 缺失的第一个正数
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240617;

import java.util.HashSet;
import java.util.Set;

public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Set<Integer> dic = new HashSet<>();
        for (int i = 0; i < n; i++) {
            dic.add(nums[i]);
        }
        for (int i = 1; i <= n; i++) {
            if (!dic.contains(i)) {
                return i;
            }
        }
        return n + 1;
    }
}

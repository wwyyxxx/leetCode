/*
 * @Author: Tungbo
 * @Date: 2022-09-26 15:21:52
 * @LastEditTime: 2022-09-26 15:42:02
 * @LastEditors: Tungbo
 * @Description: leecode: 面试题 17.19. 消失的两个数字
 * 
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * 以任意顺序返回这两个数字均可。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220926;

import java.util.Arrays;

public class Solution17_19 {
    public int[] missingTwo(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length + 2;
        int twoSum = n * (n +1) / 2 - sum, limit = twoSum / 2;
        sum = 0;
        for (int i : nums) {
            if(i <= limit) { sum += i; }
        }
        int one = limit * (limit + 1) / 2 - sum;
        return new int[]{one, twoSum - one};
    }
}

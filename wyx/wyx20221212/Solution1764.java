/*
 * @Author: Tungbo
 * @Date: 2022-12-17 16:09:06
 * @LastEditTime: 2022-12-17 16:58:04
 * @LastEditors: Tungbo
 * @Description: leecode: 1764. 通过连接另一个数组的子数组得到一个数组
 * 
 * 给你一个长度为 n 的二维整数数组 groups ，同时给你一个整数数组 nums 。
 * 你是否可以从 nums 中选出 n 个 不相交 的子数组，使得第 i 个子数组与 groups[i] （下标从 0 开始）完全相同，且如果 i > 0 ，那么第 (i-1) 个子数组在 nums 中出现的位置在第 i 个子数组前面。
 * （也就是说，这些子数组在 nums 中出现的顺序需要与 groups 顺序相同）
 * 如果你可以找出这样的 n 个子数组，请你返回 true ，否则返回 false 
 * 如果不存在下标为 k 的元素 nums[k] 属于不止一个子数组，就称这些子数组是 不相交 的。
 * 子数组指的是原数组中连续元素组成的一个序列。
 * 
 */
package wyx.wyx20221212;

public class Solution1764 {
    
    public boolean canChoose(int[][] groups, int[] nums) {
        int p1 = 0, p2, n = nums.length;
        for (int[] group : groups) {
            p2 = 0;
            while(p1<n && p2 < group.length) {
                if(nums[p1++] == group[p2]) p2++;
                else {p1 -= p2; p2=0;} //回退
            }
            if(p2!=group.length) return false;
        }
        return true;
    }

}

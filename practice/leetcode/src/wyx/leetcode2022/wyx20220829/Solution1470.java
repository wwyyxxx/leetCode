/*
 * @Author: Tungbo
 * @Date: 2022-08-29 11:07:56
 * @LastEditTime: 2022-08-29 11:26:03
 * @LastEditors: Tungbo
 * @Description: leecode: 1470. 重新排列数组
 * 
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220829;

public class Solution1470 {

    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        int m = n;
        int numIdx = 0;
        int ansIdx = 0;
        while (ansIdx < 2 * n) {
            ans[ansIdx++] = nums[numIdx++];
            ans[ansIdx++] = nums[m++];
        }
        return ans;
    }

}

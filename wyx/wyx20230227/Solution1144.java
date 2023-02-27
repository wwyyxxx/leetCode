/*
 * @Author: Tungbo
 * @Date: 2023-02-27 11:29:49
 * @LastEditTime: 2023-02-27 11:34:14
 * @LastEditors: Tungbo
 * @Description: leecode: 1144. 递减元素使数组呈锯齿状
 */
package wyx.wyx20230227;

public class Solution1144 {
    public int movesToMakeZigzag(int[] nums) {
        int[] s = new int[2];
        int n = nums.length;
        for(int i = 0; i< nums.length;i++) {
            int left = i > 0 ? nums[i-1] : Integer.MAX_VALUE;
            int right = i < n -1 ? nums[i+1] : Integer.MAX_VALUE;
            s[i%2] += Math.max(nums[i] - Math.min(left, right) + 1, 0);
        }
        return Math.min(s[0],s[1]);
    }
}

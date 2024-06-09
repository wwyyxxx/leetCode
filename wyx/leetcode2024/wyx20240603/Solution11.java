/*
 * @Author: Tungbo
 * @Date: 2024-06-09 17:01:15
 * @LastEditTime: 2024-06-09 17:08:30
 * @LastEditors: Tungbo
 * @Description: leecode: 11. 盛最多水的容器
 */
package wyx.leetcode2024.wyx20240603;

public class Solution11 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int res = 0;
        while (i < j) {
            res = Math.max((j - i) * Math.min(height[i], height[j]), res);
            if(height[i] <= height[j]) {
                i++;  
            } else {
                j--;
            }
        }
        return res;
    }
}

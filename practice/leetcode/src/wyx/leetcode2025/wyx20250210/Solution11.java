/*
 * @Author: Tungbo
 * @Date: 2025-02-15 20:59:06
 * @LastEditTime: 2025-02-15 21:02:44
 * @LastEditors: Tungbo
 * @Description: leecode: 11. 盛最多水的容器
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250210;

public class Solution11 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int res = 0;
        while (i < j) {
            res = Math.max(Math.min(height[i], height[j]) * (j - i), res);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}

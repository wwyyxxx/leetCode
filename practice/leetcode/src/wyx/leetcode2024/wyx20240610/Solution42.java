/*
 * @Author: Tungbo
 * @Date: 2024-06-10 14:57:23
 * @LastEditTime: 2024-06-10 15:13:56
 * @LastEditors: Tungbo
 * @Description: leecode: 42. 接雨水
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240610;

public class Solution42 {
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            for (int j = i  - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }  
            }

            int max_right = 0;
            for (int j = i  + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }

            int min = Math.min(max_left, max_right);
            if(min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }
}

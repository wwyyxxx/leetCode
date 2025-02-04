/*
 * @Author: Tungbo
 * @Date: 2024-07-31 19:35:05
 * @LastEditTime: 2024-07-31 19:45:12
 * @LastEditors: Tungbo
 * @Description: leecode: 84. 柱状图中最大的矩形
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240729;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len == 0) return 0;
        if (len == 1) {
            return heights[0];
        }
        int res = 0;
        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] =0;
        len += 2;
        heights = newHeights;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        for (int i = 0; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curWidth * curHeight);
            }
            stack.addLast(i);
        }
        return res;
    }
}

/*
 * @Author: Tungbo
 * @Date: 2024-07-30 16:52:28
 * @LastEditTime: 2024-07-30 17:18:11
 * @LastEditors: Tungbo
 * @Description: leecode: 739. 每日温度
 */
package wyx.leetcode2024.wyx20240729;

import java.util.Stack;

public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }
}

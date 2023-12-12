/*
 * @Author: Tungbo
 * @Date: 2023-12-12 10:40:08
 * @LastEditTime: 2023-12-12 11:44:19
 * @LastEditors: Tungbo
 * @Description: leecode: 2454. 下一个更大元素 IV
 */
package wyx.wyx20231211;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class Solution2454 {
    public int[] secondGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<Integer>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < nums.length; ++i) {
            while (!pq.isEmpty() && pq.peek()[0] < nums[i]) {
                res[pq.poll()[1]] = nums[i];
            }
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                pq.offer(new int[]{nums[stack.peek()], stack.peek()});
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }


    public int[] secondGreaterElement1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < res.length; i++) {
            int cnt = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    cnt++;
                    if(cnt == 2) {
                        res[i] = nums[j];
                        break;
                    }
                }
            }
        }
        return res;
    }
}

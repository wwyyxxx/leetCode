/*
 * @Author: Tungbo
 * @Date: 2023-03-17 23:03:36
 * @LastEditTime: 2023-03-17 23:03:40
 * @LastEditors: Tungbo
 * @Description: leecode: 2389. 和有限的最长子序列
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230313;

import java.util.Arrays;

public class Solution2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length, m = queries.length;
        int[] answer = new int[m];
        Arrays.sort(nums);
        int p = 0, tempSum = 0;
        for(int i = 0; i < m; i++) {
            int target = queries[i];
            int idx = 0, sum = 0;
            while(idx < n) {
                sum += nums[idx];
                if(sum > target) break;
                idx++;
            }
            answer[i] = idx;
        }
        return answer;
    }
}
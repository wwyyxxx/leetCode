/*
 * @Author: Tungbo
 * @Date: 2025-02-15 21:05:59
 * @LastEditTime: 2025-02-15 21:09:40
 * @LastEditors: Tungbo
 * @Description: leecode: 1679. K 和数对的最大数目
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250210;

import java.util.Arrays;

public class Soluition1679 {
    public int maxOperations(int[] nums, int k) {
        int i = 0, j = nums.length - 1;
        int cnt = 0;
        Arrays.sort(nums);
        while (i < j) {
            if (nums[i] + nums[j] == k) {
                i++;
                j--;
                cnt++;
            } else if (nums[i] + nums[j] > k){
                j--;
            } else {
                i++;
            }
        }
        return cnt;
    }
}

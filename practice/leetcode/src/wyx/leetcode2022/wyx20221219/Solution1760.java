/*
 * @Author: Tungbo
 * @Date: 2022-12-20 18:27:35
 * @LastEditTime: 2022-12-20 18:41:04
 * @LastEditors: Tungbo
 * @Description: leecode: 1760. 袋子里最少数目的球
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221219;

import java.util.Arrays;

public class Solution1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        int ans = 0;
        while (left <= right) {
            int y = (left + right) / 2;
            long ops = 0;
            for (int x : nums) {
                ops += (x - 1) / y;
            }
            if (ops <= maxOperations) {
                ans = y;
                right = y - 1;
            } else {
                left = y + 1;
            }
        }
        return ans;
    }
}

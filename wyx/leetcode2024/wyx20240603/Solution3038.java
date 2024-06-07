/*
 * @Author: Tungbo
 * @Date: 2024-06-07 20:57:44
 * @LastEditTime: 2024-06-07 20:57:48
 * @LastEditors: Tungbo
 * @Description: leecode: 3038. 相同分数的最大操作数目 I
 */
package wyx.leetcode2024.wyx20240603;

public class Solution3038 {
    public int maxOperations(int[] nums) {
        int n = nums.length;
        if(n < 2) return 0;
        int res = 1;
        int target = nums[0] + nums[1];
        for(int i = 3; i < n; i += 2) {
            if(target != nums[i] + nums[i - 1]) {
                return res;
            }
            res++;
        }
        return res;
    }
}

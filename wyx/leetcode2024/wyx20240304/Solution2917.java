/*
 * @Author: Tungbo
 * @Date: 2024-03-06 17:02:03
 * @LastEditTime: 2024-03-06 17:02:05
 * @LastEditors: Tungbo
 * @Description: leecode: 2917. 找出数组中的 K-or 值
 */
package wyx.leetcode2024.wyx20240304;

public class Solution2917 {
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for(int i = 0; i < 31; i++) {
            int cnt = 0;
            for(int num : nums) {
                cnt += num >> i & 1;
            }
            if(cnt >= k) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}

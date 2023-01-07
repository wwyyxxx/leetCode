/*
 * @Author: Tungbo
 * @Date: 2023-01-07 20:32:09
 * @LastEditTime: 2023-01-07 20:41:20
 * @LastEditors: Tungbo
 * @Description: leecode: 1658. 将 x 减到 0 的最小操作数
 */
package wyx.wyx20230112;

public class Solution1658 {

    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int i : nums) {
            target += i;
        }
        if(target <0) return -1;
        int ans = -1, n = nums.length, left = 0, sum = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while(sum > target) sum -= nums[left++];
            if(sum == target) ans = Math.max(ans, right-left+1);
        }
        return ans < 0? -1: n - ans;
    }

}

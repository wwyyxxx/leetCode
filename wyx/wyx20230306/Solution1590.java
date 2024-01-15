/*
 * @Author: Tungbo
 * @Date: 2023-03-10 11:51:03
 * @LastEditTime: 2023-03-10 11:51:29
 * @LastEditors: Tungbo
 * @Description: leecode: 1590. 使数组和能被 P 整除
 */
package wyx.wyx20230306;

public class Solution1590 {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int m = n + 1;
        long[] preSum = new long[m];
        for(int i = 0; i < n;i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }
        Long target = preSum[m-1] % p;
        if(target == 0) return 0;
        for(int i = 1; i < m; i++) {
            for(int j = 0; j< m-i; j++) {
                long temp = preSum[m-1] - (preSum[j+i] - preSum[j]);
                if(temp!=0 && temp % p == 0) return i;
            }
        }
        return -1;
        // Map<Long,Integer> map = new HashMap<>();
        // for(int i = n-1; i >= 0; i--) {
        //     if(map.containsKey(preSum[i])) return map.get(preSum[i]) - i;
        //     map.put(preSum[i] - target,i);
        // }
    }
}

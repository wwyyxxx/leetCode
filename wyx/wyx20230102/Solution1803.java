/*
 * @Author: Tungbo
 * @Date: 2023-01-05 18:50:30
 * @LastEditTime: 2023-01-05 19:28:40
 * @LastEditors: Tungbo
 * @Description: leecode: 1803. 统计异或值在范围内的数对有多少
 */
package wyx.wyx20230102;

import java.util.HashMap;

public class Solution1803 {
    public int countPairs(int[] nums, int low, int high) {
        // int ans = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if(nums[i] > high) continue;
        //     for (int j = i+1; j < nums.length; j++) {
        //         if(nums[j] > high) continue;
        //         int t = nums[j] ^ nums[i];
        //         if(low <= t && t <= high) ans++;
        //     }
        // }
        // return ans;
        int ans = 0;
        var cnt = new HashMap<Integer, Integer>();
        for (int x : nums) cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        for (++high; high > 0; high >>= 1, low >>= 1) {
            var nxt = new HashMap<Integer, Integer>();
            for (var e : cnt.entrySet()) {
                int x = e.getKey(), c = e.getValue();
                if ((high & 1) == 1) ans += c * cnt.getOrDefault(x ^ (high - 1), 0);
                if ((low & 1) == 1)  ans -= c * cnt.getOrDefault(x ^ (low - 1), 0);
                nxt.put(x >> 1, nxt.getOrDefault(x >> 1, 0) + c);
            }
            cnt = nxt;
        }
        return ans / 2;
    }
}

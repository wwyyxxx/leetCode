/*
 * @Author: Tungbo
 * @Date: 2023-03-16 11:12:51
 * @LastEditTime: 2023-03-16 11:12:55
 * @LastEditors: Tungbo
 * @Description: leecode: 2488. 统计中位数为 K 的子数组
 */
package wyx.wyx20230313;

import java.util.HashMap;
import java.util.Map;

public class Solution2488 {
    public int countSubarrays(int[] nums, int k) {
        int pos = 0;
        while(nums[pos] != k) pos++;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0, ans = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += i == pos ? 0 : nums[i] < k ? -1 : 1;
            if(i < pos) {
                map.put(sum,map.getOrDefault(sum,0)+1);
            } else {
                int pre0 = map.getOrDefault(sum,0);
                int pre1 = map.getOrDefault(sum-1,0);
                ans+=pre0+pre1;
            }
        }
        return ans;
    }
}

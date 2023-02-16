/*
 * @Author: Tungbo
 * @Date: 2023-02-16 10:53:02
 * @LastEditTime: 2023-02-16 11:09:04
 * @LastEditors: Tungbo
 * @Description: leecode: 2341. 数组能形成多少数对
 */
package wyx.wyx20230213;

import java.util.HashSet;
import java.util.Set;

public class Solution2341 {
    public int[] numberOfPairs(int[] nums) {
        int[] ans = new int[2];
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) {
                ans[0]++;
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        ans[1] = nums.length - ans[0] * 2;
        return ans;
    }
}

/*
 * @Author: Tungbo
 * @Date: 2023-01-17 20:45:09
 * @LastEditTime: 2023-01-17 23:13:31
 * @LastEditors: Tungbo
 * @Description: leecode: 1814. 统计一个数组中好对子的数目
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230116;

import java.util.HashMap;
import java.util.Map;

public class Solution1814 {
    Map<Integer, Integer> dic = new HashMap<Integer, Integer>();
    private int MOD = (int) (1e9 + 7);
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int countNicePairs(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int numI = nums[i], numIRev = getRev(nums[i]);
            int key = numI - numIRev;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            long cur = ((long)e.getValue() * (e.getValue() - 1) / 2) % MOD;
            ans += cur;
            ans %= MOD;
        }
        return ans;
    }

    private int getRev(int num) {
        if (dic.containsKey(num))
            return dic.get(num);
        int temp = num;
        int res = 0;
        while (temp != 0) {
            res = res * 10 + temp % 10;
            temp /= 10;
        }
        dic.put(num, res);
        return res;
    }
}

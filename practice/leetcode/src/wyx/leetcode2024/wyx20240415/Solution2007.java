/*
 * @Author: Tungbo
 * @Date: 2024-04-18 14:39:04
 * @LastEditTime: 2024-04-18 15:34:07
 * @LastEditors: Tungbo
 * @Description: leecode: 2007. 从双倍数组中还原原数组
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240415;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2007 {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2== 1) {
            return new int[0];
        }
        Arrays.sort(changed);
        int m = n/2;
        int[] res = new int[m];
        int ansIdx = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int x : changed) {
            if(!cnt.containsKey(x)) {
                if(ansIdx == res.length) return new int[0];
                res[ansIdx++] = x;
                cnt.merge(x * 2, 1, Integer::sum);
            } else {
                cnt.merge(x, -1, (oldVal, newVal) -> oldVal + newVal);
                if (cnt.get(x) == 0) {
                    cnt.remove(x);
                }
            }
        }
        return res;
    }
}

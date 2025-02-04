/*
 * @Author: Tungbo
 * @Date: 2024-05-12 17:53:47
 * @LastEditTime: 2024-05-12 17:53:52
 * @LastEditors: Tungbo
 * @Description: leecode: 1553. 吃掉 N 个橘子的最少天数
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240506;

import java.util.HashMap;
import java.util.Map;

public class Solution1553 {
    private final Map<Integer, Integer> memo = new HashMap<>();
    public int minDays(int n) {
        if(n <= 1) {
            return n;
        }
        Integer res = memo.get(n);
        if(res != null) return res;
        res = Math.min(minDays(n/2) + n % 2, minDays(n / 3) + n % 3) + 1;
        memo.put(n, res);
        return res;
    }
}

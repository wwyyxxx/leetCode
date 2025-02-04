package practice.leetcode.src.wyx.leetcode2023.wyx20230410;

import java.util.HashMap;
import java.util.Map;

/*
 * @Author: Tungbo
 * @Date: 2023-04-13 19:55:03
 * @LastEditTime: 2023-04-13 19:55:08
 * @LastEditors: Tungbo
 * @Description: leecode: 2404. 出现最频繁的偶数元素
 */
public class Solution2404 {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int x : nums) {
            if (x % 2 == 0) {
                count.put(x, count.getOrDefault(x, 0) + 1);
            }
        }
        int res = -1, ct = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (res == -1 || entry.getValue() > ct || entry.getValue() == ct && res > entry.getKey()) {
                res = entry.getKey();
                ct = entry.getValue();
            }
        }
        return res;
    }

}

/*
 * @Author: Tungbo
 * @Date: 2025-02-13 11:24:15
 * @LastEditTime: 2025-02-13 11:28:52
 * @LastEditors: Tungbo
 * @Description: leecode: 1742. 盒子中小球的最大数量
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250210;

import java.util.HashMap;
import java.util.Map;

public class Solution1742 {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> dic = new HashMap<>();
        int res = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int cnt = 0;
            int temp = i;
            while (temp > 0) {
                cnt += temp % 10;
                temp /= 10;
            }
            int val = dic.getOrDefault(cnt, 0) + 1;
            res = Math.max(res, val);
            dic.put(cnt, val);
        }
        return res;
    }
}

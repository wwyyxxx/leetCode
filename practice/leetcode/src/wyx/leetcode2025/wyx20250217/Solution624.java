/*
 * @Author: Tungbo
 * @Date: 2025-02-19 18:25:57
 * @LastEditTime: 2025-02-19 18:26:01
 * @LastEditors: Tungbo
 * @Description: leecode: 624. 数组列表中的最大距离
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250217;

import java.util.List;

public class Solution624 {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MIN_VALUE / 2;
        int max= Integer.MAX_VALUE / 2;
        int res = 0;
        for (List<Integer> arr : arrays) {
            int x = arr.get(0);
            int y = arr.get(arr.size() - 1);
            res = Math.max(res, Math.max(y - min, max - x));
            min = Math.min(min, x);
            max = Math.max(max, y);
        }
        return res;
    }
}

/*
 * @Author: Tungbo
 * @Date: 2025-02-11 10:55:29
 * @LastEditTime: 2025-02-11 10:58:49
 * @LastEditors: Tungbo
 * @Description: leecode: 1431. 拥有最多糖果的孩子
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250210;

import java.util.ArrayList;
import java.util.List;

public class solution1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> kids = new ArrayList<Boolean>();
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        for (int i = 0; i < candies.length; i++) {
            kids.add(candies[i] + extraCandies >= max);
        }
        return kids;
    }
}

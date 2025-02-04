/*
 * @Author: Tungbo
 * @Date: 2022-11-23 14:17:20
 * @LastEditTime: 2022-11-23 12:26:31
 * @LastEditors: Tungbo
 * @Description: leecode: 1742. 盒子中小球的最大数量
 * 
 * 编号 321 的小球应当放入编号 3 + 2 + 1 = 6 的盒子，而编号 10 的小球应当放入编号 1 + 0 = 1 的盒子。
 * 给你两个整数 lowLimit 和 highLimit ，返回放有最多小球的盒子中的小球数量。
 * 如果有多个盒子都满足放有最多小球，只需返回其中任一盒子的小球数量。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221121;

import java.util.HashMap;
import java.util.Map;

public class Solution1742 {
    public int countBalls(int lowLimit, int highLimit) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int x = i, box = 0;
            while (x != 0) {
                box += x % 10;
                x /= 10;
            }

            int count = map.getOrDefault(box, 0) + 1;
            ans = Math.max(ans, count);
            map.put(box, count);
        }
        return ans;
    }
}

/*
 * @Author: Tungbo
 * @Date: 2025-03-19 21:33:33
 * @LastEditTime: 2025-03-19 21:35:39
 * @LastEditors: Tungbo
 * @Description: leecode: 2610. 转换二维数组
 */
package practice.leetcode.src.wyx.leetcode2025.wyx0317;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2610 {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for(int x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (!cnt.isEmpty()) {
            List<Integer> row = new ArrayList<>(cnt.keySet());
            ans.add(row);

            for(Integer x :row) {
                int c = cnt.get(x) - 1;
                if (c == 0) {
                    cnt.remove(x);
                } else {
                    cnt.put(x, c);
                }
            }
        }
        return ans;
    }
}

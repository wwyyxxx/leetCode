/*
 * @Author: Tungbo
 * @Date: 2024-08-09 14:17:22
 * @LastEditTime: 2024-08-09 14:30:57
 * @LastEditors: Tungbo
 * @Description: leecode: 118. 杨辉三角
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240805;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> path = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    path.add(1);
                } else {
                    path.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(path);
        }
        return res;
    }
}

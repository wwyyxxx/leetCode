package practice.leetcode.src.wyx.leetcode2024.wyx20250128;

import java.util.ArrayList;
import java.util.List;
/*
 * @Author: Tungbo
 * @Date: 2025-01-27 00:06:50
 * @LastEditTime: 2025-01-27 00:34:50
 * @LastEditors: Tungbo
 * @Description: leecode: 119. 杨辉三角 II
 */
public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer>[] res = new List[rowIndex+1];
        res[0] = List.of(1);
        for (int i = 1; i < res.length; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(res[i-1].get(j-1) + res[i-1].get(j));
            }
            row.add(1);
            res[i] = row;
        }
        return res[rowIndex];
    }
}

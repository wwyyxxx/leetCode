/*
 * @Author: Tungbo
 * @Date: 2024-12-21 19:56:46
 * @LastEditTime: 2024-12-21 20:13:09
 * @LastEditors: Tungbo
 * @Description: leecode: 2545. 根据第 K 场考试的分数排序
 */
package wyx.leetcode2024.wyx20241216;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution2656 {
    public int[][] sortTheStudents(int[][] score, int k) {
        int m = score.length, n = score[0].length;
        int[][] ans = new int[m][n];
        Map<Integer, Integer> dic = new HashMap<>();
        Integer[] sortIndex = new Integer[m];
        for (int i = 0; i < m; i++) {
            sortIndex[i] = score[i][k];
            dic.put(score[i][k], i);
        }

        Arrays.sort(sortIndex, new Comparator<Integer>() {

            @Override
            public int compare(Integer arg0, Integer arg1) {
                return arg1 - arg0;
            }
            
        });

        for (int i = 0; i < m; i++) {
            int index = dic.get(sortIndex[i]);
            for (int j = 0; j < n; j++) {
                ans[i][j] = score[index][j];
            }
        }
        return ans;
    }
}

/*
 * @Author: Tungbo
 * @Date: 2024-12-21 19:56:46
 * @LastEditTime: 2024-12-21 20:15:41
 * @LastEditors: Tungbo
 * @Description: leecode: 2545. 根据第 K 场考试的分数排序
 */
package wyx.leetcode2024.wyx20241216;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution2656 {
    
    /**
     * 根据第 k 列的分数对学生进行排序
     * @param score 学生的分数数组
     * @param k 要排序的列索引
     * @return 排序后的学生分数数组
     */
    public int[][] sortTheStudents(int[][] score, int k) {
        int m = score.length, n = score[0].length; // 获取学生数量和每个学生的分数数量
        int[][] ans = new int[m][n]; // 初始化结果数组
        Map<Integer, Integer> dic = new HashMap<>(); // 创建一个字典来存储分数和对应的学生索引
        Integer[] sortIndex = new Integer[m]; // 创建一个数组来存储第 k 列的分数

        // 遍历每个学生，填充 sortIndex 和 dic
        for (int i = 0; i < m; i++) {
            sortIndex[i] = score[i][k]; // 获取第 k 列的分数
            dic.put(score[i][k], i); // 将分数和对应的学生索引存入字典
        }

        // 对 sortIndex 进行排序
        Arrays.sort(sortIndex, new Comparator<Integer>() {
            @Override
            public int compare(Integer arg0, Integer arg1) {
                return arg1 - arg0; // 按降序排序
            }
        });

        // 根据排序后的 sortIndex 填充结果数组 ans
        for (int i = 0; i < m; i++) {
            int index = dic.get(sortIndex[i]); // 获取排序后分数对应的学生索引
            for (int j = 0; j < n; j++) {
                ans[i][j] = score[index][j]; // 将对应学生的分数填入结果数组
            }
        }
        return ans; // 返回排序后的学生分数数组
    }
}

/*
 * @Author: Tungbo
 * @Date: 2023-02-28 20:29:02
 * @LastEditTime: 2023-02-28 20:29:05
 * @LastEditors: Tungbo
 * @Description: leecode: 2363. 合并相似的物品
 */
package wyx.wyx20230227;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution2363 {
    public List<List<Integer>> mergeSimilarItems1(int[][] items1, int[][] items2) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        int n = items1.length, m = items2.length;
        for(int i = 0; i < n; i++) {
            treeMap.put(items1[i][0], treeMap.getOrDefault(items1[i][0], 0) + items1[i][1]);
        }
        for(int i = 0; i < m; i++) {
            treeMap.put(items2[i][0], treeMap.getOrDefault(items2[i][0], 0) + items2[i][1]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: treeMap.entrySet()) {
            ans.add(Arrays.asList(entry.getKey(),entry.getValue()));
        }
        return ans;
    }

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[] cnt = new int[1001];
        for (var x : items1) {
            cnt[x[0]] += x[1];
        }
        for (var x : items2) {
            cnt[x[0]] += x[1];
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < cnt.length; ++i) {
            if (cnt[i] > 0) {
                ans.add(List.of(i, cnt[i]));
            }
        }
        return ans;
    }
}

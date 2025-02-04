package practice.leetcode.src.wyx.leetcode2024.wyx20240311;
/*
 * @Author: Tungbo
 * @Date: 2024-03-17 22:53:21
 * @LastEditTime: 2024-03-17 23:45:55
 * @LastEditors: Tungbo
 * @Description: leecode: 310. 最小高度树
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<Integer>();
        if (n == 1) {
            res.add(0);
            return res;
        }

        int[] degree = new int[n];

        List<List<Integer>> map = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if(degree[i] == 1) queue.add(i);
        }

        while (!queue.isEmpty()) {
            res.clear();
            int  size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                res.add(cur);

                List<Integer> neighbors = map.get(cur);
                for (int neighbor : neighbors) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        return res;
    }
}

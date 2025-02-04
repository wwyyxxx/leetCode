/*
 * @Author: Tungbo
 * @Date: 2023-09-12 17:01:33
 * @LastEditTime: 2023-09-18 14:00:22
 * @LastEditors: Tungbo
 * @Description: leecode: 1462. 课程表 IV
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230911;

import java.util.ArrayList;
import java.util.List;

public class Solution1462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] g = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            g[i] = new ArrayList<Integer>();
        }
        boolean[] vi = new boolean[numCourses];
        boolean[][] isPre = new boolean[numCourses][numCourses];
        for (int[] p : prerequisites) {
            g[p[0]].add(p[1]);
        }
        for (int i = 0; i < numCourses; ++i) {
            dfs(g, isPre, vi, i);
        }
        List<Boolean> res = new ArrayList<Boolean>();
        for (int[] query : queries) {
            res.add(isPre[query[0]][query[1]]);
        }
        return res;
    }

    public void dfs(List<Integer>[] g, boolean[][] isPre, boolean[] vi, int cur) {
        if (vi[cur]) {
            return;
        }
        vi[cur] = true;
        for (int ne : g[cur]) {
            dfs(g, isPre, vi, ne);
            isPre[cur][ne] = true;
            for (int i = 0; i < isPre.length; ++i) {
                isPre[cur][i] = isPre[cur][i] | isPre[ne][i];
            }
        }
    }
}

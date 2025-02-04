/*
 * @Author: Tungbo
 * @Date: 2023-12-11 16:59:36
 * @LastEditTime: 2023-12-12 10:03:48
 * @LastEditors: Tungbo
 * @Description: leecode: 1631. 最小体力消耗路径
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20231211;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import practice.leetcode.src.wyx.bean.UnionFind;

public class Solution1631 {
    public int minimumEffortPath(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) {
                    edges.add(new int[] {
                            Math.abs(mat[i][j + 1] - mat[i][j]),
                            i * N + j,
                            i * N + j + 1
                    });
                }
                if (i + 1 < M) {
                    edges.add(new int[] {
                            Math.abs(mat[i + 1][j] - mat[i][j]),
                            i * N + j,
                            (i + 1) * N + j
                    });
                }
            }
        }
        Collections.sort(edges,(o1,o2) -> o1[0] - o2[0]);
        UnionFind uf = new UnionFind(N*M);
        for (int[] edge : edges) {
            uf.union(edge[1], edge[2]);
            if(uf.find(0) == uf.find(M*N-1)) {
                return edge[0];
            }
        }
        return 0;
    }
}

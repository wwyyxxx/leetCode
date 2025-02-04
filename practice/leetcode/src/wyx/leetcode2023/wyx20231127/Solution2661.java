/*
 * @Author: Tungbo
 * @Date: 2023-12-01 13:48:05
 * @LastEditTime: 2023-12-01 13:48:07
 * @LastEditors: Tungbo
 * @Description: leecode: 2661. 找出叠涂元素
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20231127;

import java.util.HashMap;
import java.util.Map;

public class Solution2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length, m = mat[0].length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        int[] c1 = new int[n], c2 = new int[m];
        for (int i = 0; i < n * m; i++) {
            int[] info = map.get(arr[i]);
            int x = info[0], y = info[1];
            if (++c1[x] == m || ++c2[y] == n) return i;
        }
        return -1; // never
    }
}

/*
 * @Author: Tungbo
 * @Date: 2023-05-15 21:19:11
 * @LastEditTime: 2023-05-15 21:19:14
 * @LastEditors: Tungbo
 * @Description: leecode: 1072. 按列翻转得到最大值等行数
 */
package wyx.wyx20230515;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < m; i++) {
            char[] arr = new char[n];
            Arrays.fill(arr, '0');
            for (int j = 0; j < n; j++) {
                // 如果 matrix[i][0] 为 1，则对该行元素进行翻转
                arr[j] = (char) ('0' + (matrix[i][j] ^ matrix[i][0]));
            }
            String s = new String(arr);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res = Math.max(res, entry.getValue());
        }
        return res;
    }
}

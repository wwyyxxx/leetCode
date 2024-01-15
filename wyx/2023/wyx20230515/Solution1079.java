/*
 * @Author: Tungbo
 * @Date: 2023-05-19 20:35:17
 * @LastEditTime: 2023-05-19 20:35:20
 * @LastEditors: Tungbo
 * @Description: leecode: 1079. 活字印刷
 */
package wyx.wyx20230515;

import java.util.HashMap;

public class Solution1079 {
    private static final int MX = 8;
    private static final int[][] c = new int[MX][MX];

    static {
        for (int i = 0; i < MX; i++) {
            c[i][0] = c[i][i] = 1;
            for (int j = 1; j < i; j++)
                c[i][j] = c[i - 1][j - 1] + c[i - 1][j]; // 预处理组合数
        }
    }

    public int numTilePossibilities(String tiles) {
        var counts = new HashMap<Character, Integer>(); // 统计每个字母的出现次数
        for (var c : tiles.toCharArray())
            counts.merge(c, 1, Integer::sum); // counts[c]++
        int m = counts.size(), n = tiles.length();
        var f = new int[m + 1][n + 1];
        f[0][0] = 1; // 构造空序列的方案数
        int i = 1;
        for (var cnt : counts.values()) { // 枚举第 i 种字母
            for (int j = 0; j <= n; j++) // 枚举序列长度 j
                for (int k = 0; k <= j && k <= cnt; k++) // 枚举第 i 种字母选了 k 个
                    f[i][j] += f[i - 1][j - k] * c[j][k];
            i++;
        }
        int ans = 0;
        for (int j = 1; j <= n; j++)
            ans += f[m][j];
        return ans;
    }
}

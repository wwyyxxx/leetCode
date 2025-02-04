/*
 * @Author: Tungbo
 * @Date: 2023-12-07 16:41:27
 * @LastEditTime: 2023-12-07 17:30:09
 * @LastEditors: Tungbo
 * @Description: leecode: 1466. 重新规划路线
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20231204;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1466 {
    
    private List<int[]>[] g;
    
    public int minReorder(int n, int[][] connections) {
        g = new List[n];
        Arrays.setAll(g, k->new ArrayList<>());
        for(int[] e : connections) {
            int a = e[0], b = e[1];
            g[a].add(new int[]{b,1});
            g[b].add(new int[]{a,0});
        }
        return dfs(0, -1);
    }

    private int dfs(int a, int fa) {
        int ans = 0;
        for(int[] e : g[a]) {
            int b = e[0], c =e[1];
            if(b != fa) {
                ans += c +dfs(b, a);
            }
        }
        return ans;
    }
}

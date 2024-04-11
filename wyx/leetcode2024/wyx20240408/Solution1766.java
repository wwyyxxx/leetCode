/*
 * @Author: Tungbo
 * @Date: 2024-04-11 10:11:29
 * @LastEditTime: 2024-04-11 10:11:32
 * @LastEditors: Tungbo
 * @Description: leecode: 1766. 互质树
 */
package wyx.leetcode2024.wyx20240408;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1766 {
    private static final int MX = 51;
    private static final int[][] coprime = new int[MX][MX];

    static {
        // 预处理
        // coprime[i] 保存 [1, MX) 中与 i 互质的所有元素
        for (int i = 1; i < MX; i++) {
            int k = 0;
            for (int j = 1; j < MX; j++) {
                if (gcd(i, j) == 1) {
                    coprime[i][k++] = j;
                }
            }
        }
    }

    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            g[x].add(y);
            g[y].add(x);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int[] valDepth = new int[MX];
        int[] valNodeId = new int[MX];
        dfs(0, -1, 1, g, nums, ans, valDepth, valNodeId);
        return ans;
    }

    private void dfs(int x, int fa, int depth, List<Integer>[] g, int[] nums, int[] ans, int[] valDepth, int[] valNodeId) {
        // x 的节点值
        int val = nums[x];

        // 计算与 val 互质的祖先节点值中，节点深度最大的节点编号
        int maxDepth = 0;
        for (int j : coprime[val]) {
            if (j == 0) {
                break;
            }
            if (valDepth[j] > maxDepth) {
                maxDepth = valDepth[j];
                ans[x] = valNodeId[j];
            }
        }

        // tmpDepth 和 tmpNodeId 用于恢复现场
        int tmpDepth = valDepth[val];
        int tmpNodeId = valNodeId[val];

        // 保存 val 对应的节点深度和节点编号
        valDepth[val] = depth;
        valNodeId[val] = x;

        // 向下递归
        for (int y : g[x]) {
            if (y != fa) {
                dfs(y, x, depth + 1, g, nums, ans, valDepth, valNodeId);
            }
        }

        // 恢复现场
        valDepth[val] = tmpDepth;
        valNodeId[val] = tmpNodeId;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

/*
 * @Author: Tungbo
 * @Date: 2022-11-10 15:49:09
 * @LastEditTime: 2022-11-10 16:39:03
 * @LastEditors: Tungbo
 * @Description: leecode: 864. 获取所有钥匙的最短路径
 * 
 * 给定一个二维网格 grid ，其中：
 *  '.' 代表一个空房间
 *  '#' 代表一堵
 *  '@' 起点
 *  小写字母代表钥匙
 *  大写字母代表锁
 * 
 * 我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。
 * 我们不能在网格外面行走，也无法穿过一堵墙。如果途经一个钥匙，我们就把它捡起来。
 * 除非我们手里有对应的钥匙，否则无法通过锁。
 * 
 * 假设 k 为 钥匙/锁 的个数，且满足 1 <= k <= 6，字母表中的前 k 个字母在网格中都有自己对应的一个小写和一个大写字母。
 * 换言之，每个锁有唯一对应的钥匙，每个钥匙也有唯一对应的锁。
 * 另外，代表钥匙和锁的字母互为大小写并按字母顺序排列。
 * 
 * 返回获取所有钥匙所需要的移动的最少次数。如果无法获取所有钥匙，返回 -1 。
 * 
 */
package wyx.wyx20221107;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution864 {

    int[][] dic = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int k = 0; // 钥匙数量
        int si = 0, sj = 0; // 起点
        for (int i = 0; i < m; i++) {
            String s = grid[i];
            for (int j = 0; j < n; j++) {
                if (Character.isLowerCase(s.charAt(j))) {
                    k++;
                } else if (s.charAt(j) == '@') {
                    si = i;
                    sj = j;
                }
            }
        }
        int ans = 0;
        // BFS记录
        Deque<int[]> q = new ArrayDeque<int[]>();
        q.offer(new int[] { si, sj, 0 });
        // 记录访问过节点
        boolean[][][] vis = new boolean[m][n][1 << k];
        vis[si][sj][0] = true;
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1], state = cur[2];
                if (state == (1 << k) - 1)
                    return ans;
                // 往四个方向搜索
                for (int j = 0; j < dic.length; j++) {
                    int xj = x + dic[j][0], yj = y + dic[j][1];
                    // 在边界范围内
                    if (xj >= 0 && yj >= 0 && xj < m && yj < n) {
                        char c = grid[xj].charAt(yj);
                        // 是墙，或者是锁，但此时没有对应的钥匙，无法通过
                        if (c == '#' || (Character.isUpperCase(c) && (state >> (c - 'A') & 1) == 0)) {
                            continue;
                        }
                        //是钥匙
                        int nxt = state;
                        if (Character.isLowerCase(c)) {
                            //更新状态
                            nxt |= 1 << (c - 'a');
                        }
                        // 此状态未访问过，入队
                        if (!vis[xj][yj][nxt]) {
                            vis[xj][yj][nxt] = true;
                            q.offer(new int[] { xj, yj, nxt });
                        }
                    }
                }
            }
            ans++;
        }
        return -1;
    }

}

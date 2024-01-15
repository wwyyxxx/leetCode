/*
 * @Author: Tungbo
 * @Date: 2022-07-18 16:43:43
 * @LastEditTime: 2022-07-18 18:47:26
 * @LastEditors: Tungbo
 * @Description: leecode: 749. 隔离病毒
 * 
 * 病毒扩散得很快，现在你的任务是尽可能地通过安装防火墙来隔离病毒
 * 
 * 假设世界由 m x n 的二维矩阵 isInfected 组成， isInfected[i][j] == 0 表示该区域未感染病毒，而  isInfected[i][j] == 1 表示该区域已感染病毒。可以在任意 2 个相邻单元之间的共享边界上安装一个防火墙（并且只有一个防火墙）。
 * 每天晚上，病毒会从被感染区域向相邻未感染区域扩散，除非被防火墙隔离。现由于资源有限，每天你只能安装一系列防火墙来隔离其中一个被病毒感染的区域（一个区域或连续的一片区域），且该感染区域对未感染区域的威胁最大且 保证唯一 。
 * 你需要努力使得最后有部分区域不被病毒感染，如果可以成功，那么返回需要使用的防火墙个数; 如果无法实现，则返回在世界被病毒全部感染时已安装的防火墙个数
 * 
 */
package wyx.wyx20220718;

import java.util.ArrayList;
import java.util.List;

public class Solution749 {
    int move[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int containVirus(int[][] isInfected) {
        boolean settled[][] = new boolean[isInfected.length][isInfected[0].length];
        // 标志格子1
        for (int i = 0; i < isInfected.length; i++) {
            for (int j = 0; j < isInfected[0].length; j++) {
                if (isInfected[i][j] == 1) {
                    settled[i][j] = true;
                }
            }
        }
        int ans = 0;
        while (true) {
            List<List<int[]>> blocks = findBlocks(isInfected);
            if (blocks.size() == 0)
                break;
            int idx = -1, max = -1, wall = -1;
            // 找到可以感染格子最多的块
            for (int i = 0; i < blocks.size(); i++) {
                int a[] = countBorders(blocks.get(i), isInfected, settled);
                if (max < a[1]) {
                    max = a[1];
                    wall = a[0];
                    idx = i;
                }
            }
            if (wall == 0)
                break;
            ans += wall;
            // 标记被选定围住的那个连通块，全部设为0：
            List<int[]> locked = blocks.get(idx);
            for (int i = 0; i < locked.size(); i++) {
                int a[] = locked.get(i);
                isInfected[a[0]][a[1]] = 0;
            }
            // 然后再把其他的连通块向外扩展1：
            for (int i = 0; i < blocks.size(); i++) {
                if (i == idx)
                    continue;
                List<int[]> list = blocks.get(i);
                for (int j = 0; j < list.size(); j++) {
                    int a[] = list.get(j);
                    for (int k = 0; k < 4; k++) {
                        int x = a[0] + move[k][0], y = a[1] + move[k][1];
                        if (x >= 0 && x < isInfected.length && y >= 0 && y < isInfected[0].length && !settled[x][y]) {
                            isInfected[x][y] = 1;
                            settled[x][y] = true;
                        }
                    }
                }
            }
        }
        return ans;
    }

    private int[] countBorders(List<int[]> list, int[][] isInfected, boolean[][] settled) {
        // 计算连通块与0的相邻边数，以及相邻的0的数量
        int ans[] = new int[2];// 边、0
        boolean cameBefore[][] = new boolean[isInfected.length][isInfected[0].length];
        for (int i = 0; i < list.size(); i++) {
            int a[] = list.get(i);
            for (int j = 0; j < 4; j++) {
                int x = a[0] + move[j][0], y = a[1] + move[j][1];
                if (x >= 0 && x < isInfected.length && y >= 0 && y < isInfected[0].length && isInfected[x][y] == 0
                        && !settled[x][y]) {
                    ans[0]++;
                    if (!cameBefore[x][y]) {
                        cameBefore[x][y] = true;
                        ans[1]++;
                    }
                }
            }
        }
        return ans;
    }

    private List<List<int[]>> findBlocks(int[][] isInfected) {
        // 提取每个病毒连区域
        boolean cameBefore[][] = new boolean[isInfected.length][isInfected[0].length];
        List<List<int[]>> ans = new ArrayList<>();
        for (int i = 0; i < isInfected.length; i++) {
            for (int j = 0; j < isInfected[0].length; j++) {
                if (isInfected[i][j] == 1 && !cameBefore[i][j]) {
                    cameBefore[i][j] = true;
                    List<int[]> list = new ArrayList<>();
                    list.add(new int[] { i, j });
                    for (int k = 0; k < list.size(); k++) {
                        int a[] = list.get(k);
                        for (int p = 0; p < 4; p++) {
                            int x = a[0] + move[p][0], y = a[1] + move[p][1];
                            if (x >= 0 && x < isInfected.length && y >= 0 && y < isInfected[0].length
                                    && isInfected[x][y] == 1 && !cameBefore[x][y]) {
                                list.add(new int[] { x, y });
                                cameBefore[x][y] = true;
                            }
                        }
                    }
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}

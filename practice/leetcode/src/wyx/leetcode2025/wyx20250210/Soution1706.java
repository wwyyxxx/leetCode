package practice.leetcode.src.wyx.leetcode2025.wyx20250210;

/*
 * @Author: Tungbo
 * @Date: 2025-02-15 20:40:41
 * @LastEditTime: 2025-02-15 20:40:45
 * @LastEditors: Tungbo
 * @Description: leecode: 1706. 球会落何处
 */
public class Soution1706 {
    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] ans = new int[n];
        for (int i = 0; i < ans.length; i++) {
            int curCol = i;
            for(int[] row : grid) {
                int d = row[curCol];
                curCol += d;
                if (curCol < 0 || curCol >= n || row[curCol] != d) {
                    curCol = -1;
                    break;
                }
            }
            ans[i] = curCol;
        }
        return ans;
    }
}

package wyx.wyx20220523;

/*
 * @Author: Tungbo
 * @Date: 2022-05-24 16:27:40
 * @LastEditTime: 2022-05-26 21:51:29
 * @LastEditors: Tungbo
 * @Description: leecode: 200. 岛屿数量
 * 
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 
 */
public class Solution200 {
    
    int ans = 0;
    int n,m;
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        boolean[][] dp = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!dp[i][j] && grid[i][j] == '1') {
                    ans++;
                    barckNumIslands(grid,dp,i,j);
                }
            }
        }
        return ans;
    }

    private void barckNumIslands(char[][] grid, boolean[][] dp, int i, int j){
        if(i< 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0' || dp[i][j]) return;
        dp[i][j] = true;
        int[][] dic = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        for(int[] nums : dic) {
            barckNumIslands(grid,dp,i+nums[0],j+nums[1]);
        }
    }


    public int numIslands1(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        //遍历处理上下左右四种情况  通过测试用例：31 / 49
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0) {
                    if(j == 0) {
                        if(grid[i][j] == '1') {
                            ans++;
                        }
                    } else if(grid[i][j] == '1' && grid[i][j-1] != '1'){
                        ans++;
                    }
                } else if(i == n-1){
                    if(j == 0) {
                        if(grid[i][j] == '1' && grid[i-1][j] != '1') {
                            ans++;
                        }
                    } else if(grid[i][j] == '1' && grid[i][j-1] != '1' && grid[i-1][j] != '1'){
                        ans++;
                    }
                } else {
                    if(j == 0) {
                        if(grid[i][j] == '1' && grid[i-1][j] != '1' && grid[i+1][j] != '1') {
                            ans++;
                        }
                    } else if(grid[i][j] == '1' && grid[i][j-1] != '1' && grid[i+1][j] != '1' && grid[i-1][j] != '1'){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}

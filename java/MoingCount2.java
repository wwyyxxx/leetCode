/*
 * @Author: Tungbo
 * @Date: 2021-06-28 15:31:05
 * @LastEditTime: 2021-06-28 16:20:49
 * @LastEditors: Tungbo
 * @Description: leecode: 机器人的运动范围
 */
public class MovingCount2 {

    public static void main(String[] args) {
    }


    int m,n,k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];
        return dfs(0,0,0,0);
    }

    private int dfs(int m, int n, int si, int sj) {
        if (this.m < m || this.n < n || si+sj > this.k || visited[m][n]) return 0;
        visited[m][n] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }

}

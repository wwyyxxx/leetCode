/*
 * @Author: Tungbo
 * @Date: 2021-06-22 17:13:50
 * @LastEditTime: 2021-06-28 15:25:11
 * @LastEditors: Tungbo
 * @Description: leecode: 机器人的运动范围
 */
public class MovingCount {
    public static void main(String[] args) {
        int[][] res = new int[1][2];
        System.out.println(movingCount(36,11,15));
    }
    
    static int count = 0;
    public static int movingCount(int m, int n, int k) {
        int[][] res = new int[m][n];
        if (k<=0) return 1;
        moving(0,0,m,n,k,res);
        return count;
    }

    private static void moving(int i, int j, int m, int n, int k,int[][] res) {
        if(i>=m || j>=n) return;
        if(checkMN(i,j,k)) {
            if(res[i][j] != -1) {
                res[i][j] = -1;
                count++; 
            }
            moving(i,j+1,m,n,k,res);
            moving(i+1,j,m,n,k,res);
        }
    }

    private static boolean checkMN(int m, int n, int k) {
        int result = 0;
        while (m != 0 || n != 0) {
            result = result + m % 10;
            result = result + n % 10;
            m = m / 10;
            n = n / 10;
        }
        return result<=k;
    }
}
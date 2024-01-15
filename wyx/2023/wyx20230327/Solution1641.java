package wyx.wyx20230327;

/*
 * @Author: Tungbo
 * @Date: 2023-03-29 17:43:17
 * @LastEditTime: 2023-03-29 17:46:47
 * @LastEditors: Tungbo
 * @Description: leecode: 1641. 统计字典序元音字符串的数目
 */
public class Solution1641 {

    private Integer[][] f;
    private int n;

    public int countVowelStrings(int n) {
        this.n = n;
        f = new Integer[n][5];
        return dfs(0,0);
    }

    private int dfs(int i, int j) {
        if(i>=n) return 1;
        if(f[i][j]!=null) return f[i][j];
        int ans = 0;
        for (int k = j; k < 5; k++) {
            ans += dfs(i + 1, k);
        }
        return f[i][j] = ans;
    }
    
}
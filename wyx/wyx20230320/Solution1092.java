package wyx.wyx20230320;

/*
 * @Author: Tungbo
 * @Date: 2023-03-28 15:02:14
 * @LastEditTime: 2023-03-28 15:56:40
 * @LastEditors: Tungbo
 * @Description: leecode: 1092. 最短公共超序列
 */
public class Solution1092 {

    String[][] map;
    int[][] memo;
    String s,t;
    public String shortestCommonSupersequence(String str1, String str2) {
        s = str1;
        t = str2;
        map = new String[str1.length()][str2.length()];
        return makeAns(str1.length() - 1, str2.length() - 1);
    }



    
    private String makeAns(int i, int j) {
        if (i < 0) return t.substring(0, j + 1);
        if (j < 0) return s.substring(0, i + 1);
        char c1 = s.charAt(i);
        char c2 = t.charAt(j);
        if (c1 == c2)
            return makeAns(i - 1, j - 1) + c1;
        if (makeAnsDfs(i, j) == makeAnsDfs(i-1, j) + 1)
            return makeAns(i-1, j) + c1;
        return makeAns(i, j - 1) + c2;
    }
    private int makeAnsDfs(int i, int j) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;
        if(memo[i][j] > 0) return memo[i][j];
        char c1 = s.charAt(i);
        char c2 = t.charAt(j);
        if (c1 == c2)
            return memo[i][j] = makeAnsDfs(i-1, j-1) + 1;
        return memo[i][j] = Math.min(makeAnsDfs(i-1, j), makeAnsDfs(i, j-1)) + 1;
    }

    //2
    private String dfs(int i, int j) {
        if (i < 0)
            return t.substring(0, j + 1);
        if (j < 0)
            return s.substring(0, i + 1);
        if(map[i][j] != null) return map[i][j];
        char c1 = s.charAt(i);
        char c2 = t.charAt(j);
        if (c1 == c2)
            return map[i][j] = dfs(i-1, j-1) + c1;
        String ans1 = dfs(i - 1, j);
        String ans2 = dfs(i, j - 1);
        if (ans1.length() < ans2.length())
            return map[i][j] = ans1 + c1;
        return map[i][j] = ans2 + c2;
    }


    // 1
    private String dfs(String str1, String str2) {
        if(str1.length() == 0) return str2;
        if(str2.length() == 0) return str1;
        String s1 = str1.substring(0, str1.length() - 1);
        String s2 = str2.substring(0, str2.length() - 1);
        char c1 = str1.charAt(str1.length() - 1);
        char c2 = str2.charAt(str2.length() - 1);
        if(c1 == c2) return shortestCommonSupersequence(s1, s2) + c1;
        String ans1 = shortestCommonSupersequence(s1, str2);
        String ans2 = shortestCommonSupersequence(str1, s2);
        if(ans1.length() < ans2.length()) return ans1 + c1;
        return ans2 + c2;
    }

}

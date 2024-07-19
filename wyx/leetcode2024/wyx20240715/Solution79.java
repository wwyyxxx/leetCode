/*
 * @Author: Tungbo
 * @Date: 2024-07-19 15:40:53
 * @LastEditTime: 2024-07-19 17:51:27
 * @LastEditors: Tungbo
 * @Description: leecode: 79. 单词搜索
 */
package wyx.leetcode2024.wyx20240715;

public class Solution79 {
    int m, n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] visted = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtarck(i, j, 0, board, word, visted)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtarck(int i, int j, int k, char[][] board, String word, boolean[][] visted) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(k)) {
            return false;
        }
        board[i][j] = '0';
        boolean res = backtarck(i + 1, j, k + 1, board, word, visted) || backtarck(i - 1, j, k + 1, board, word, visted)
                || backtarck(i, j + 1, k + 1, board, word, visted) || backtarck(i, j - 1, k + 1, board, word, visted);
        board[i][j] = word.charAt(k);
        return res;
    }
}

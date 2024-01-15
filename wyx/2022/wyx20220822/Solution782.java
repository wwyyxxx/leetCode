/*
 * @Author: Tungbo
 * @Date: 2022-08-23 20:50:23
 * @LastEditTime: 2022-08-23 20:50:26
 * @LastEditors: Tungbo
 * @Description: leecode: 782. 变为棋盘
 */
package wyx.wyx20220822;

public class Solution782 {
    public int movesToChessboard(int[][] board) {
        int n = board.length, rowCnt = 0, colCnt = 0, rowSwap = 0, colSwap = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) == 1) {
                    return -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            rowCnt += board[0][i];
            colCnt += board[i][0];
            if (board[i][0] == i % 2) {
                rowSwap++;
            }
            if (board[0][i] == i % 2) {
                colSwap++;
            }
        }
        if (rowCnt != n / 2 && rowCnt != (n + 1) / 2) {
            return -1;
        }
        if (colCnt != n / 2 && colCnt != (n + 1) / 2) {
            return -1;
        }
        if (n % 2 == 1) {
            if (rowSwap % 2 == 1) {
                rowSwap = n - rowSwap;
            }
            if (colSwap % 2 == 1) {
                colSwap = n - colSwap;
            }
        } else {
            rowSwap = Math.min(rowSwap, n - rowSwap);
            colSwap = Math.min(colSwap, n - colSwap);
        }
        return (rowSwap + colSwap) / 2;
    }
}

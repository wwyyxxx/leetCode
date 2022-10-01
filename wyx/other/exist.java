package wyx.other;

/*
 * @Author: Tungbo
 * @Date: 2021-06-15 14:54:25
 * @LastEditTime: 2021-07-26 15:21:27
 * @LastEditors: Tungbo
 * @Description: leecode: 矩阵中的路径
 */
class exist{
    public boolean exist1(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0;i<board.length;i++) {
            for(int j = 0; j<board[i].length;j++) {
                if(board[i][j]==word.charAt(0)) {
                    if(check(board,words,i,j,0)) return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, char[] words,int i,int j,int index) {
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!=words[index]) return false;
        if(index == words.length -1) return true;
        board[i][j] = '\0';
        boolean flag =  check(board,words,i+1,j,index+1) || check(board,words,i-1,j,index+1) ||
            check(board,words,i,j+1,index+1) || check(board,words,i,j-1,index+1);
        board[i][j] = words[index];
        return flag;
    }
}
/*
 * @Author: Tungbo
 * @Date: 2023-12-27 19:05:12
 * @LastEditTime: 2023-12-27 19:05:15
 * @LastEditors: Tungbo
 * @Description: leecode: 2660. 保龄球游戏的获胜者
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20231225;

public class Solution2660 {
    public int isWinner(int[] player1, int[] player2) {
        int s1 = sum(player1), s2 = sum(player2);
        return s1 == s2 ? 0 : s1 > s2 ? 1 : 2 ;
    }

    public int sum(int[] player) {
        int sum = 0;
        for(int i = 0; i < player.length; i++) {
            int flag = (i > 0 && player[i-1] == 10) || (i > 1 && player[i-2] == 10) ? 2 : 1;
            sum += player[i] * flag;
        }
        return sum;
    }
}

/*
 * @Author: Tungbo
 * @Date: 2022-12-08 12:39:53
 * @LastEditTime: 2022-12-08 12:48:26
 * @LastEditors: Tungbo
 * @Description: leecode: 1812. 判断国际象棋棋盘中一个格子的颜色
 * 
 * 给你一个坐标 coordinates ，它是一个字符串，表示国际象棋棋盘中一个格子的坐标。下图是国际象棋棋盘示意图。
 * 如果所给格子的颜色是白色，请你返回 true，如果是黑色，请返回 false 。
 * 给定坐标一定代表国际象棋棋盘上一个存在的格子。坐标第一个字符是字母，第二个字符是数字。
 * 
 */
package wyx.wyx20221205;

public class Solution1812 {

    public boolean squareIsWhite(String coordinates) {
        int x = (coordinates.charAt(0) - 'a') % 2;
        int y = (coordinates.charAt(1) - '0') % 2;
        System.out.println(x +"," + y);
        // x == 0 and y == 0
        // x == 1 and y == 1
        return x==y;
    }

}

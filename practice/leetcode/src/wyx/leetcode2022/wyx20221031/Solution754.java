/*
 * @Author: Tungbo
 * @Date: 2022-11-04 14:47:27
 * @LastEditTime: 2022-11-04 15:38:07
 * @LastEditors: Tungbo
 * @Description: leecode: 754. 到达终点数字
 * 
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 * 你可以做一些数量的移动 numMoves :
 *  每次你可以选择向左或向右移动。
 *  第 i 次移动（从  i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
 * 给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221031;

public class Solution754 {
    public int reachNumber(int target) {
        int s = 0, n = 0;
        target = Math.abs(target);
        while(s < target || (s -  target) % 2 == 1) {
            s += ++n;
        }
        return n;
    }
}

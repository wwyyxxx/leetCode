/*
 * @Author: Tungbo
 * @Date: 2022-12-01 10:42:12
 * @LastEditTime: 2022-12-01 11:08:43
 * @LastEditors: Tungbo
 * @Description: leecode: 1779. 找到最近的有相同 X 或 Y 坐标的点
 * 
 * 给你两个整数 x 和 y ，表示你在一个笛卡尔坐标系下的 (x, y) 处。
 * 同时，在同一个坐标系下给你一个数组 points ，其中 points[i] = [ai, bi] 表示在 (ai, bi) 处有一个点。
 * 当一个点与你所在的位置有相同的 x 坐标或者相同的 y 坐标时，我们称这个点是 有效的 。
 * 
 * 请返回距离你当前位置 曼哈顿距离 最近的 有效 点的下标（下标从 0 开始）。
 * 如果有多个最近的有效点，请返回下标 最小 的一个。如果没有有效点，请返回 -1 。
 * 
 * 两个点 (x1, y1) 和 (x2, y2) 之间的 曼哈顿距离 为 abs(x1 - x2) + abs(y1 - y2) 。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221128;

public class Solution1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int idx = -1, hm = Integer.MAX_VALUE;
        for (int i = points.length - 1; i >= 0; i--) {
            if (x != points[i][0] && y != points[i][1])
                continue;
            int t = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
            if (hm >= t) {
                idx = i;
                hm = t;
            }
        }
        return idx;
    }
}

/*
 * @Author: Tungbo
 * @Date: 2022-07-29 19:14:41
 * @LastEditTime: 2022-07-29 19:22:15
 * @LastEditors: Tungbo
 * @Description: leecode: 593. 有效的正方形
 * 
 * 给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true
 * 点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的
 * 一个 有效的正方形 有四条等边和四个等角(90度角)
 * 
 */
package wyx.wyx20220725;

public class Solution593 {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return isoscelesTriangle(p1,p2,p3) && isoscelesTriangle(p1,p2,p4)
        && isoscelesTriangle(p1,p3,p4) && isoscelesTriangle(p2,p3,p4);
    }

    //正方形任意三点 组成 等腰三角形
    private boolean isoscelesTriangle(int[] p1, int[] p2, int[] p3) {
        int d1 = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) *(p1[1] - p2[1]);
        int d2 = (p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) *(p1[1] - p3[1]);
        int d3 = (p2[0] - p3[0]) * (p2[0] - p3[0]) + (p2[1] - p3[1]) *(p2[1] - p3[1]);
        return (d1 > d2 && d1 == d2 + d3 && d2 == d3) 
            || (d2 > d1 && d2 == d1 + d3 && d1 == d3)
            || (d3 > d2 && d3 == d1 + d2 && d1 == d2);
    }

}

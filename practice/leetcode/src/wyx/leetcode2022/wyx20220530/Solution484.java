/*
 * @Author: Tungbo
 * @Date: 2022-06-05 12:24:04
 * @LastEditTime: 2022-06-05 12:40:04
 * @LastEditors: Tungbo
 * @Description: leecode: 478. 在圆内随机生成点
 * 
 * 给定圆的半径和圆心的位置，实现函数 randPoint ，在圆中产生均匀随机点。
 * Solution(double radius, double x_center, double y_center) 用圆的半径 radius 和圆心的位置 (x_center, y_center) 初始化对象
 * randPoint() 返回圆内的一个随机点。圆周上的一点被认为在圆内。答案作为数组返回 [x, y] 。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220530;

import java.util.Random;

public class Solution484 {

    Random random = new Random();
    double x, y,r;
    
    public Solution484(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
    }
    
    public double[] randPoint() {
        //random.nextDouble() return 0.0 - 1.0
        //len 有二分之一的概率取到小于等于 r/2 的值，而 r/2扫过的面积仅为总面积的1/4.
        //所以先平方再开方
        double len = Math.sqrt(random.nextDouble() * r*r), ange = random.nextDouble() * 2 * Math.PI;
        //Math.cos  sin 计算边长
        double rx = x + len * Math.cos(ange), ry = y + len * Math.sin(ange);
        return new double[]{rx,ry};
    }
}

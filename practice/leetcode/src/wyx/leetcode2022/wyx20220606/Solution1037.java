/*
 * @Author: Tungbo
 * @Date: 2022-06-08 11:37:35
 * @LastEditTime: 2022-06-08 12:29:49
 * @LastEditors: Tungbo
 * @Description: leecode: 1037. 有效的回旋镖
 * 
 * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，如果这些点构成一个 回旋镖 则返回 true 。
 * 回旋镖 定义为一组三个点，这些点 各不相同 且 不在一条直线上 。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220606;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1037 {
    
    public static void main(String[] args) {
        System.out.println(new Solution1037().Solution(new int[][]{{0,0},{1,1},{1,1}}));
    }

    public boolean Solution(int[][] points) {
        int[] v1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] v2 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }

    //[[1,1],[2,2],[7,7]] 有问题
    public boolean Solution1(int[][] points) {
        // int[][] dic = new int[][]{{-1,0},{-1,1},{0,1},{1,1},{1,0},{-1,1},{0,-1},{-1,-1}};
        int[][] diff = new int[2][2];
        // int[] temp = points[0];

        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] arg1, int[] arg2) {
                return arg1[0] - arg2[0];
            }
        });
        
        for(int i = 1; i< points.length; i++) {
            diff[i-1][0] = points[i][0] - points[i-1][0];
            diff[i-1][1] = points[i][1] - points[i-1][1];
        }
        return !Arrays.equals(diff[0],diff[1]);
    }

}

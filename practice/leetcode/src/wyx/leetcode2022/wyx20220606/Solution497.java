/*
 * @Author: Tungbo
 * @Date: 2022-06-09 16:04:08
 * @LastEditTime: 2022-06-09 16:26:17
 * @LastEditors: Tungbo
 * @Description: leecode: 497. 非重叠矩形中的随机点
 * 
 * 给定一个由非重叠的轴对齐矩形的数组 rects ，其中 rects[i] = [ai, bi, xi, yi] 表示 (ai, bi) 是第 i 个矩形的左下角点，(xi, yi) 是第 i 个矩形的右上角点。设计一个算法来随机挑选一个被某一矩形覆盖的整数点。矩形周长上的点也算做是被矩形覆盖。所有满足要求的点必须等概率被返回。
 * 在给定的矩形覆盖的空间内的任何整数点都有可能被返回。
 * 请注意 ，整数点是具有整数坐标的点。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220606;

import java.util.Random;

public class Solution497 {

    int[][] rs;
    int n;
    int sum[];
    Random random = new Random();

    //[[[-2, -2, 1, 1], [2, 2, 4, 6]]]
    public Solution497(int[][] rects) {
        rs = rects;
        n = rects.length;
        sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            // +1 是点数问题，而不是面积
            sum[i] += sum[i-1] + (rs[i-1][2] - rs[i-1][0] + 1) * (rs[i-1][3] - rs[i-1][1] + 1);
        }
    }
    
    public int[] pick() {
        // +1 是点数问题，而不是面积
        int val = random.nextInt(sum[n]) + 1;
        int l = 0, r = n;
        while(l < r) {
            int mid = l + (r - l) /2;
            //线性层面上包含了这个值
            if(sum[mid] >= val) r = mid;
            //找到最小的那个
            else l  = mid + 1;
        }
        int[] cur = rs[r - 1];
        // +1 是点数问题，而不是面积
        int x = random.nextInt(cur[2] - cur[0] + 1) + cur[0];
        int y = random.nextInt(cur[3] - cur[1] + 1) + cur[1];
        return new int[]{x,y};
    }

}

/*
 * @Author: Tungbo
 * @Date: 2023-10-27 17:39:33
 * @LastEditTime: 2023-10-27 17:39:36
 * @LastEditors: Tungbo
 * @Description: leecode: 1465. 切割后面积最大的蛋糕
 */
package wyx.wyx20231023;

import java.util.Arrays;

public class Solution1465 {
    int mod = (int) 1e9 +7;
    
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxH =  Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);

        for(int i = 1; i< horizontalCuts.length; i++) {
            maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i-1]);
        }

        int maxV = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        for(int i = 1; i< verticalCuts.length; i++) {
            maxV = Math.max(maxV, verticalCuts[i] - verticalCuts[i-1]);
        }
    
        return (int)((maxH * 1L * maxV) % mod);
    }
}

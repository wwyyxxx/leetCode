/*
 * @Author: Tungbo
 * @Date: 2024-02-02 15:17:23
 * @LastEditTime: 2024-02-04 10:05:27
 * @LastEditors: Tungbo
 * @Description: leecode: 1686. 石子游戏 VI
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240129;

import java.util.Arrays;

public class Solution1686 {
    public int stoneGameVI(int[] a, int[] b) {
        Integer[] ids = new Integer[a.length];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids,(i , j) -> a[j] + b[j] - a[i] - b[i]);
        int diff = 0;
        for (int i = 0; i < ids.length; i++) {
            if(i%2 == 0) {
                diff += a[ids[i]];
            } else {
                diff -= b[ids[i]];
            }
        }
        return diff == 0 ? 0 : diff > 0 ? 1 : -1 ;
    }

}

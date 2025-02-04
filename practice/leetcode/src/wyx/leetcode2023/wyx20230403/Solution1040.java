/*
 * @Author: Tungbo
 * @Date: 2023-04-07 16:05:22
 * @LastEditTime: 2023-04-07 16:12:37
 * @LastEditors: Tungbo
 * @Description: leecode: 1040. 移动石子直到连续 II
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230403;

import java.util.Arrays;

public class Solution1040 {

    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        int e1 = stones[n - 2] - stones[0] - n + 2;
        int e2 = stones[n - 1] - stones[1] - n + 2; // 计算空位
        int maxMove = Math.max(e1, e2);
        if(e1 == 0 || e2 == 0) return new int[]{Math.min(2, maxMove), maxMove};
        int maxCnt = 0, left = 0;
        for(int right = 0; right < n; right++) {
            while(stones[right] - stones[left] + 1 >n) left++;
            maxCnt = Math.max(maxCnt, right - left + 1);
        }
        return new int[]{n - maxCnt, maxMove};

    }

}

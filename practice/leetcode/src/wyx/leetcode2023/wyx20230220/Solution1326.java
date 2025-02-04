/*
 * @Author: Tungbo
 * @Date: 2023-02-21 11:14:32
 * @LastEditTime: 2023-02-21 11:32:47
 * @LastEditors: Tungbo
 * @Description: leecode: 1326. 灌溉花园的最少水龙头数目
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230220;

public class Solution1326 {
    public int minTaps(int n, int[] ranges) {
        int[] rightMost = new int[n+1];
        for(int i = 0; i <=n; i++) {
            int r = ranges[i];
            if(i > r) rightMost[i-r] = i + r;
            else rightMost[0] = Math.max(rightMost[0], i+r);
        }
        int ans = 0;
        int curRight = 0, nextRight = 0;
        for(int i =0; i<n; i++) {
            nextRight = Math.max(nextRight, rightMost[i]);
            if(i == curRight) {
                if(i == nextRight) return -1;
                ans++;
                curRight = nextRight;
            }
        }
        return ans;
    }
}

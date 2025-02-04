package practice.leetcode.src.wyx.leetcode2023.wyx20230206;

import java.util.Arrays;
/*
 * @Author: Tungbo
 * @Date: 2023-02-11 12:42:53
 * @LastEditTime: 2023-02-07 13:04:07
 * @LastEditors: Tungbo
 * @Description: leecode: 2335. 装满杯子需要的最短总时长
 */
public class Solution2335 {
    public int fillCups(int[] amount) {
        int a = amount[0], b = amount[1], c = amount[2];
        int ans = 0;
        while(amount[0] > 0 || amount[1] > 0 || amount[2] > 0) {
            Arrays.sort(amount);
            amount[2]--;amount[1]--;
            ans++;
        }
        return ans;
    }
}

package wyx.wyx20230130;

import java.util.Arrays;

/*
 * @Author: Tungbo
 * @Date: 2023-02-04 12:06:56
 * @LastEditTime: 2023-02-04 12:34:21
 * @LastEditors: Tungbo
 * @Description: leecode: 1798. 你能构造出连续值的最大数目
 */
public class Solution1798 {

    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int ans = 1;
        for(int coin : coins) {
            if(coin > ans) break;
            ans += coin;
        }
        return ans;
    }

}

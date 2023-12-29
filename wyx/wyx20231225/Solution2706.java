/*
 * @Author: Tungbo
 * @Date: 2023-12-29 10:45:38
 * @LastEditTime: 2023-12-29 10:45:40
 * @LastEditors: Tungbo
 * @Description: leecode: 2706. 购买两块巧克力
 */
package wyx.wyx20231225;

import java.util.Arrays;

public class Solution2706 {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int d = money- (prices[0] + prices[1]);
        return d >= 0 ? d : money;
    }
}

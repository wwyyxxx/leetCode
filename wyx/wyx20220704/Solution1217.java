/*
 * @Author: Tungbo
 * @Date: 2022-07-08 16:06:02
 * @LastEditTime: 2022-07-08 16:19:10
 * @LastEditors: Tungbo
 * @Description: leecode:1217. 玩筹码
 * 
 * 有 n 个筹码。第 i 个筹码的位置是 position[i] 。
 * 我们需要把所有筹码移到同一个位置。在一步中，我们可以将第 i 个筹码的位置从 position[i] 改变为:
 *      position[i] + 2 或 position[i] - 2 ，此时 cost = 0
 *      position[i] + 1 或 position[i] - 1 ，此时 cost = 1
 * 返回将所有筹码移动到同一位置上所需要的 最小代价。
 * 
 */
package wyx.wyx20220704;

public class Solution1217 {

    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for (int i = 0; i < position.length; i++) {
            if(position[i] % 2 == 1) odd++;
            else even++;
        }
        return Math.min(odd,even);
    }

}

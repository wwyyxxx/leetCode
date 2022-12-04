/*
 * @Author: Tungbo
 * @Date: 2022-12-04 14:25:17
 * @LastEditTime: 2022-12-04 15:56:26
 * @LastEditors: Tungbo
 * @Description: leecode: 1774. 最接近目标价格的甜点成本
 * 
 * 目前共有 n 种冰激凌基料和 m 种配料可供选购。而制作甜点需要遵循以下几条规则：
 *  必须选择 一种 冰激凌基料。
 *  可以添加 一种或多种 配料，也可以不添加任何配料。
 *  每种类型的配料 最多两份 。
 * 给你以下三个输入：
 *  baseCosts ，一个长度为 n 的整数数组，其中每个 baseCosts[i] 表示第 i 种冰激凌基料的价格。
 *  toppingCosts，一个长度为 m 的整数数组，其中每个 toppingCosts[i] 表示 一份 第 i 种冰激凌配料的价格。
 *  target ，一个整数，表示你制作甜点的目标价格。
 * 你希望自己做的甜点总成本尽可能接近目标价格 target 。
 * 返回最接近 target 的甜点成本。如果有多种方案，返回 成本相对较低 的一种。
 * 
 */
package wyx.wyx20221128;

import java.util.Arrays;

public class Solution1774 {

    int ans = Integer.MAX_VALUE;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for (int base : baseCosts) {
            dfs(0, base, target, toppingCosts);
        }
        return ans;
    }

    private void dfs(int i, int sum, int target, int[] toppingCosts) {
        if (Math.abs(ans - target) < sum - target) { // 已经比最小差值要大，再加没意义
            return;
        } else if (Math.abs(ans - target) >= Math.abs(sum - target)) {
            if (Math.abs(ans - target) > Math.abs(sum - target)) {
                ans = sum;
            } else {
                ans = Math.min(ans, sum); // 取小值
            }
        }
        if (i == toppingCosts.length)
            return;
        dfs(i + 1, sum + toppingCosts[i] * 2, target, toppingCosts);
        dfs(i + 1, sum + toppingCosts[i], target, toppingCosts);
        dfs(i + 1, sum, target, toppingCosts);
    }
}

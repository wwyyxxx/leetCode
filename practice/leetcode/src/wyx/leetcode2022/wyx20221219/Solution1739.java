/*
 * @Author: Tungbo
 * @Date: 2022-12-25 19:17:17
 * @LastEditTime: 2022-12-25 19:18:22
 * @LastEditors: Tungbo
 * @Description: leecode: 1739. 放置盒子
 * 
 * 有一个立方体房间，其长度、宽度和高度都等于 n 个单位。
 * 请你在房间里放置 n 个盒子，每个盒子都是一个单位边长的立方体。放置规则如下：
 *  你可以把盒子放在地板上的任何地方。
 *  如果盒子 x 需要放置在盒子 y 的顶部，那么盒子 y 竖直的四个侧面都 必须 与另一个盒子或墙相邻。
 * 给你一个整数 n ，返回接触地面的盒子的 最少 可能数量。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221219;

public class Solution1739 {
    public int minimumBoxes(int n) {
        int ans = 0, maxN = 0;
        for (int i = 1; maxN + ans + i <= n; ++i) {
            ans += i;
            maxN += ans;
        }
        for (int j = 1; maxN < n; ++j) {
            ++ans;
            maxN += j;
        }
        return ans;
    }
}

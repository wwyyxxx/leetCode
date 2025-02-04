/*
 * @Author: Tungbo
 * @Date: 2023-09-01 18:01:08
 * @LastEditTime: 2023-09-01 18:02:02
 * @LastEditors: Tungbo
 * @Description: leecode: 2240. 买钢笔和铅笔的方案数
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230828;

public class Solution2240 {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (cost1 < cost2) {
            return waysToBuyPensPencils(total, cost2, cost1);
        }
        long res = 0, cnt = 0;
        while (cnt * cost1 <= total) {
            res += (total - cnt * cost1) / cost2 + 1;
            cnt++;
        }
        return res;
    }
}

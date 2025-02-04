/*
 * @Author: Tungbo
 * @Date: 2025-01-06 23:14:51
 * @LastEditTime: 2025-01-06 23:34:38
 * @LastEditors: Tungbo
 * @Description: leecode: 2274. 不含特殊楼层的最大连续楼层数
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20241230;

import java.util.Arrays;

public class Solution2274 {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int ans = Math.max(special[0] - bottom, top - special[special.length]);
        for (int i = 1; i < special.length; i++) {
            ans = Math.max(ans, special[i] - special[i-1] - 1);
        }
        return ans;
    }
}

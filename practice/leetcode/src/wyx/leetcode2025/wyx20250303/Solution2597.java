/*
 * @Author: Tungbo
 * @Date: 2025-03-07 23:44:47
 * @LastEditTime: 2025-03-07 23:49:24
 * @LastEditors: Tungbo
 * @Description: leecode: 2597. 美丽子集的数目
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250303;

import java.util.HashMap;
import java.util.Map;

public class Solution2597 {

    private int ans = -1;

    public int beautifulSubsets(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        dfs(0, nums, k, cnt);
        return ans;
    }

    private void dfs(int i, int[] nums, int k, Map<Integer, Integer> cnt) {
        if (i == nums.length) {
            ans++;
            return;
        }
        dfs(i + 1, nums, k, cnt);
        int x = nums[i];
        if (cnt.getOrDefault(x - k, 0) == 0 && cnt.getOrDefault(x + k, 0) == 0) {
            cnt.merge(x, 1, Integer::sum); // 选
            dfs(i + 1, nums, k, cnt); // 讨论 nums[i+1] 选或不选
            cnt.merge(x, -1, Integer::sum); // 撤销，恢复现场
        }
    }
}

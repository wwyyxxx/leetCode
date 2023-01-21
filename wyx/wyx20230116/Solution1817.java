/*
 * @Author: Tungbo
 * @Date: 2023-01-20 14:45:57
 * @LastEditTime: 2023-01-20 15:21:35
 * @LastEditors: Tungbo
 * @Description: leecode: 1817. 查找用户活跃分钟数
 */
package wyx.wyx20230116;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k];
        Map<Integer,Set<Integer>> ansMap = new HashMap<Integer,Set<Integer>>();
        for (int i = 0; i < logs.length; i++) {
            int[] log = logs[i];
            ansMap.computeIfAbsent(log[0], key -> new HashSet<>()).add(log[1]);
            // Set<Integer> cur = ansMap.getOrDefault(log[0], new HashSet<Integer>());
            // cur.add(log[1]);
            // ansMap.put(log[0],cur);
        }
        for (Map.Entry<Integer,Set<Integer>> entry : ansMap.entrySet()) {
            ans[entry.getValue().size() - 1]++;
        }
        return ans;
    }
}

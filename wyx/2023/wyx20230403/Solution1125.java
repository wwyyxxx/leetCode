/*
 * @Author: Tungbo
 * @Date: 2023-04-08 18:18:54
 * @LastEditTime: 2023-04-08 18:18:58
 * @LastEditors: Tungbo
 * @Description: leecode: 1125. 最小的必要团队
 */
package wyx.wyx20230403;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution1125 {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length, m = people.size();
        HashMap<String, Integer> skill_index = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            skill_index.put(req_skills[i], i);
        }
        List<Integer>[] dp = new List[1 << n];
        dp[0] = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            int cur_skill = 0;
            for (String s : people.get(i)) {
                cur_skill |= 1 << skill_index.get(s);
            }
            for (int prev = 0; prev < dp.length; ++prev) {
                if (dp[prev] == null) {
                    continue;
                }
                int comb = prev | cur_skill;
                if (dp[comb] == null || dp[prev].size() + 1 < dp[comb].size()) {
                    dp[comb] = new ArrayList<>(dp[prev]);
                    dp[comb].add(i);
                }
            }
        }
        return dp[(1 << n) - 1].stream().mapToInt(i -> i).toArray();
    }
}

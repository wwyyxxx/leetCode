/*
 * @Author: Tungbo
 * @Date: 2024-05-14 16:41:28
 * @LastEditTime: 2024-05-14 16:41:30
 * @LastEditors: Tungbo
 * @Description: leecode: 2244. 完成所有任务需要的最少轮数
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240513;

import java.util.HashMap;
import java.util.Map;

public class Solution2244 {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> dic = new HashMap<>();
        for(int task : tasks) {
            dic.merge(task, 1, Integer::sum);
        }
        int ans = 0;
        for(int cnt : dic.values()) {
            if(cnt == 1) return -1;
            ans += (cnt + 2) / 3;
        }
        return ans;
    }
}

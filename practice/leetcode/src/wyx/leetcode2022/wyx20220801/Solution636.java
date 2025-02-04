/*
 * @Author: Tungbo
 * @Date: 2022-08-07 17:13:29
 * @LastEditTime: 2022-08-07 17:32:37
 * @LastEditors: Tungbo
 * @Description: leecode: 636. 函数的独占时间
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220801;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution636 {
    
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        int cur = -1;
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (String log : logs) {
            String[] item = log.split(":");
            int idx = Integer.valueOf(item[0]), ts = Integer.valueOf(item[2]);
            if(item[1].equals("start")) {
                if(!queue.isEmpty()) ans[queue.peekLast()] += ts -cur;
                queue.addLast(idx);
                cur = ts;
            } else {
                int func = queue.pollLast();
                ans[func] += ts - cur + 1;
                cur = ts + 1;
            }
        }
        return ans;
    }

}

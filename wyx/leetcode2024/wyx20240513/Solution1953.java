/*
 * @Author: Tungbo
 * @Date: 2024-05-16 11:32:32
 * @LastEditTime: 2024-05-16 14:19:43
 * @LastEditors: Tungbo
 * @Description: leecode: 1953. 你可以工作的最大周数
 */
package wyx.leetcode2024.wyx20240513;

import java.util.PriorityQueue;

public class Solution1953 {
    public long numberOfWeeks(int[] milestones) {
        int longest = milestones[0];
        long count = 0;
        for(int milestone : milestones) {
            longest = Math.max(milestone, longest);
            count += milestone; 
        }
        count -= longest;
        if(longest > count + 1) {
            return count * 2 +1;
        } else {
            return longest + count;
        }
    }
}

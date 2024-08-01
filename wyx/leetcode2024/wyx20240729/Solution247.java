/*
 * @Author: Tungbo
 * @Date: 2024-08-01 17:49:33
 * @LastEditTime: 2024-08-01 17:59:03
 * @LastEditors: Tungbo
 * @Description: leecode: 347. 前 K 个高频元素
 */
package wyx.leetcode2024.wyx20240729;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution247 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> dic = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            dic.put(nums[i], dic.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return dic.get(o2) - dic.get(o1);
            }
            
        });

        for(Map.Entry<Integer,Integer> entry: dic.entrySet()) {
            queue.add(entry.getKey());
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}

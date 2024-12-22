package wyx.leetcode2024.wyx20241216;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


/*
 * @Author: Tungbo
 * @Date: 2024-12-22 19:56:02
 * @LastEditTime: 2024-12-22 20:31:01
 * @LastEditors: Tungbo
 * @Description: leecode: 1387. 将整数按权重排序
 */
public class Solution1387 {

    private Map<Integer, Integer> weightCache = new HashMap<>();


    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (a.getValue() == b.getValue()) {
                return a.getKey() - b.getKey();
            }
            return a.getValue() - b.getValue();
        });
        for (int i = lo; i <= hi; i++) {
            int cnt = getNumWeight(i);
            map.put(i, cnt);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }

        while (k != 1) {
            pq.poll();
            k--;
        }
        
        return pq.poll().getKey();
    }

    private int getNumWeight(int num) {
        if(num == 1) {
            return 0;
        }

        if (weightCache.containsKey(num)) {
            return weightCache.get(num);
        }
        int cnt;
       if (num % 2 == 0) {
            cnt = getNumWeight(num / 2) + 1;
        } else {
            cnt = getNumWeight(num * 3 + 1) + 1;
       }
        weightCache.put(num, cnt);
        return cnt;
    }
}

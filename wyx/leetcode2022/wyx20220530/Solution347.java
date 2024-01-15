package wyx.wyx20220530;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @Author: Tungbo
 * @Date: 2022-06-01 15:12:17
 * @LastEditTime: 2022-06-01 15:35:13
 * @LastEditors: Tungbo
 * @Description: leecode: 347. 前 K 个高频元素
 * 
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 
 */
public class Solution347 {

    public int[] topKFrequent(int[] nums, int k) {
        //储存计算所有值出现的次数
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        int[] res = new int[k];
        //获取出现频率最高的k个
        for(int i = 0; i < k; i++) {
            int maxIdx = 0;
            int maxValue = Integer.MIN_VALUE;
            for(Integer key : map.keySet()) {
                if(map.get(key) > maxValue) {
                    maxIdx = key;
                    maxValue = map.get(key);
                }
            }
            res[i] = maxIdx;
            //每次把获取到的移除掉
            map.remove(maxIdx);
        }
        return res;
    }

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        //建立堆比较
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            //[0]-num 、[1]-count
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        //map遍历
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int num = entry.getKey() , count = entry.getValue();
            if(pq.size() >= k ) {
                //count小的话 移除
                if(pq.peek()[1] < count) {
                    pq.poll();
                    pq.offer(new int[]{num,count});
                }
            } else {
                pq.offer(new int[]{num,count});
            }
        }
        int[] res = new int[k];
        //获取出现频率最高的k个
        for(int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }

}
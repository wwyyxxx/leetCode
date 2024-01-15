/*
 * @Author: Tungbo
 * @Date: 2022-09-04 17:03:58
 * @LastEditTime: 2022-09-04 17:09:07
 * @LastEditors: Tungbo
 * @Description: leecode: 面试题 17.14. 最小K个数
 * 
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * 
 */
package wyx.wyx20220829;

import java.util.PriorityQueue;

public class Solution17_14 {
    public int[] smallestK(int[] arr, int k) {
        // Arrays.sort(arr);
        // return Arrays.copyOf(arr, k);

        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a,b)->a-b);
        for (Integer i : arr) {
            q.add(i);
        }
        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = q.poll();
        }
        return ans;
    }
}

/*
 * @Author: Tungbo
 * @Date: 2022-10-28 11:03:11
 * @LastEditTime: 2022-10-28 16:13:58
 * @LastEditors: Tungbo
 * @Description: leecode: 907. 子数组的最小值之和
 * 
 * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组
 * 由于答案可能很大，因此 返回答案模 10^9 + 7
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221024;

import java.util.LinkedList;

public class Solution907 {
    private static final int MOD = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        int n = arr.length;
        long ans = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.poll();
            }
            if(stack.isEmpty()) left[i] = -1;
            else left[i] = i;
            stack.push(i);
        }
        stack.clear();
        for(int i = n -1; i >= 0; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.poll();
            }
            if(stack.isEmpty()) right[i] = n;
            else right[i] = i;
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            ans = (ans + (long)(i - left[i]) * (right[i] - i) * arr[i]) % MOD;
        }
        return (int) ans;
    }
    
    public int sumSubarrayMins1(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        int n = arr.length;
        long ans = 0;
        for(int i = 0; i < n; i++){
            int min = arr[i];
            for(int j = i; j < n; j++){
                min = Math.min(min, arr[j]);
                ans = (ans + min) % MOD;
            }
        }
        return (int) ans;
    }

}

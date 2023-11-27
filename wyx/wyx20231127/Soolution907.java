/*
 * @Author: Tungbo
 * @Date: 2023-11-27 22:45:03
 * @LastEditTime: 2023-11-27 23:52:27
 * @LastEditors: Tungbo
 * @Description: leecode: 907. 子数组的最小值之和
 */
package wyx.wyx20231127;

import java.util.Deque;
import java.util.LinkedList;

public class Soolution907 {


    public int sumSubarrayMins(int[] arr) {
        int MOD = (int) (1e9+7);
        long ans = 0;

        if(arr == null || arr.length == 0){
            return 0;
        }

        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        Deque<Integer> stack = new LinkedList<>();

        for(int i = 0; i < arr.length; i++){
            
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) left[i] = -1;
            else left[i] = stack.peek();
            stack.push(i);
        }
        
        stack.clear();

        for(int i = arr.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && arr[stack.peek()]  >= arr[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) right[i] = arr.length;
            else right[i] = stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < arr.length; i++) {
            ans = (ans + (long)(i-left[i]) * (right[i] - 1) * arr[i]) % MOD;
        }
        return (int) ans;
    }

    public int sumSubarrayMins1(int[] arr) {
        int MOD = (int) (1e9+7);
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                min = Math.min(arr[j], min);
                ans = (ans + min) % MOD;
            }
        }
        return (int) ans;
    }
}

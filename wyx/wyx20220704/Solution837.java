/*
 * @Author: Tungbo
 * @Date: 2022-07-09 15:21:00
 * @LastEditTime: 2022-07-09 16:02:16
 * @LastEditors: Tungbo
 * @Description: leecode: 873. 最长的斐波那契子序列的长度
 * 
 * 
 * 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
 * 
 */
package wyx.wyx20220704;

import java.util.Arrays;
import java.util.List;

public class Solution837 {
    
    public static void main(String[] args) {
        System.out.println(new Solution837().lenLongestFibSubseq(new int[]{2,4,7,8,9,10,14,15,18,23,32,50}));
    }

    public int lenLongestFibSubseq(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i+1; j < arr.length - 1; j++) {
                int a = arr[i], b = arr[j], len = 2;
                for (int z = j; z < arr.length; z++) {
                    if(a + b == arr[z]) {
                        a = b;
                        b = arr[z];
                        ans = Math.max(ans, ++len);
                    } else if(a + b < arr[z]) break;
                }
            }
        }
        return ans;
    }
}

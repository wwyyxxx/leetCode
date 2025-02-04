/*
 * @Author: Tungbo
 * @Date: 2022-07-03 14:55:42
 * @LastEditTime: 2022-07-03 15:45:06
 * @LastEditors: Tungbo
 * @Description: leecode: 556. 下一个更大元素 III
 * 
 * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220627;

import java.util.Arrays;

public class Solution556 {
    
    public static void main(String[] args) {
        System.out.println(new Solution556().nextGreaterElement(101));
    }

    public int nextGreaterElement(int n) {
        String temp = String.valueOf(n);
        char[] c = temp.toCharArray();
        int i = c.length -2;
        while (i >= 0 && c[i] >= c[i + 1]) {
            i--;
        }
        if(i < 0) {
            return -1;
        }
        int j = c.length - 1;
        while (j >= 0 && c[j] <= c[i]) {
            j--;
        }

        char tempc = c[i];
        c[i] = c[j];
        c[j] = tempc;

        reverse(c, i + 1);
        
        long ans = Long.parseLong(new String(c));
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    public void reverse(char[] nums, int begin) {
        int i = begin, j = nums.length - 1;
        while (i < j) {
            char tempc = nums[i];
            nums[i] = nums[j];
            nums[j] = tempc;
            i++;
            j--;
        }
    }

    public int nextGreaterElement1(int n) {
        String temp = String.valueOf(n);
        char[] c = temp.toCharArray();
        Arrays.sort(c);
        for (int i = 0, j = c.length -1; i < j; i++,j--) {
            char tempc = c[i];
            c[i] = c[j];
            c[j] = tempc;
        }
        for (int i = 0; i < c.length -1; i++) {
            if(c[i] < c[i+1]) {}
        }
        String str = new String(c);
        Integer cInt = Integer.valueOf(str);
        if(cInt <= n) return -1;
        return cInt;
    }


}

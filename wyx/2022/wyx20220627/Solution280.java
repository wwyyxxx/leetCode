/*
 * @Author: Tungbo
 * @Date: 2022-06-28 15:41:16
 * @LastEditTime: 2022-06-28 15:48:50
 * @LastEditors: Tungbo
 * @Description: leecode: 324. 摆动排序 II
 * 
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 * 
 */
package wyx.wyx20220627;

import java.util.Arrays;

public class Solution280 {

    //[1,5,1,1,6,4]
    //[1,1,1,4,5,6]
    //[1,6,1,5,1,4]
    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n =nums.length;
        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i+=2, j--, k--) {
            nums[i] = arr[j];
            if(i + 1 < n) {
                nums[i+1] = arr[k];
            }
        }
    }

}

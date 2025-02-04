/*
 * @Author: Tungbo
 * @Date: 2023-03-25 19:43:27
 * @LastEditTime: 2023-03-25 19:44:31
 * @LastEditors: Tungbo
 * @Description: leecode: 1574. 删除最短的子数组使剩余数组有序
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230320;

public class Solution1574 {
    
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right])
            --right;
        if (right == 0) return 0; // arr 已经是非递减数组
        // 此时 arr[right-1] > arr[right]
        int ans = right; // 删除 0 到 right-1
        for (int left = 0; left == 0 || arr[left - 1] <= arr[left]; ++left) {
            while (right < n && arr[right] < arr[left])
                ++right;
            // 此时 arr[left] <= arr[right]，从 left+1 到 right-1 可以删除
            ans = Math.min(ans, right - left - 1);
        }
        return ans;
    }
}

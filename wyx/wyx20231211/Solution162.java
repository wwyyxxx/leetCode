/*
 * @Author: Tungbo
 * @Date: 2023-12-18 17:07:46
 * @LastEditTime: 2023-12-18 17:07:48
 * @LastEditors: Tungbo
 * @Description: leecode: 162. 寻找峰值
 */
package wyx.wyx20231211;

public class Solution162 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        for(int i = 0; i < n; i++) {
            int cur = nums[i];
            if((i == 0 && cur > nums[i+1]) || (i == n-1 && cur > nums[i-1])) return i;
            else if(i != 0 && i != n-1 &&cur > nums[i-1] && cur > nums[i+1]) return i;
        }
        return -1;
    }
}

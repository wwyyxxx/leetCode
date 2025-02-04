/*
 * @Author: Tungbo
 * @Date: 2024-06-18 14:30:27
 * @LastEditTime: 2024-06-18 15:13:02
 * @LastEditors: Tungbo
 * @Description: leecode: 238. 除自身以外数组的乘积
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240617;

import java.util.Arrays;

public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        Arrays.fill(prefix, 1);
        Arrays.fill(suffix, 1);
        for (int i = 0; i < n; i++) {
            if(i!=0) prefix[i] *= prefix[i - 1] * nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            if(i != n - 1) suffix[i] *= suffix[i + 1] * nums[i + 1];
        }
        System.out.println("prefix:"+ Arrays.toString(prefix));
        System.out.println("suffix:"+ Arrays.toString(suffix));
        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }
}

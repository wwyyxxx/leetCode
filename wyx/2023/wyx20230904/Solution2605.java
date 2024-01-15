/*
 * @Author: Tungbo
 * @Date: 2023-09-06 19:20:16
 * @LastEditTime: 2023-09-06 19:24:15
 * @LastEditors: Tungbo
 * @Description: leecode: 2605. 从两个数字数组里生成最小数字
 */
package wyx.wyx20230904;

import java.util.Arrays;

public class Solution2605 {
    public int minNumber(int[] nums1, int[] nums2) {
        int ans = 100;
        for (int a : nums1) {
            for (int b : nums2) {
                if (a == b) {
                    ans = Math.min(ans, a);
                } else {
                    ans = Math.min(ans, Math.min(a * 10 + b, b * 10 + a));
                }
            }
        }
        return ans;
    }
}

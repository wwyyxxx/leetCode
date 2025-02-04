/*
 * @Author: Tungbo
 * @Date: 2023-01-14 15:57:01
 * @LastEditTime: 2023-01-14 16:20:32
 * @LastEditors: Tungbo
 * @Description: leecode: 1819. 序列中不同最大公约数的数目
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230109;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1819 {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int ans = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        boolean[] has = new boolean[max+1];
        for (int num : nums) {
            has[num] = true;
        }
        for (int i = 1; i <= max; i++) {
            int g = 0;
            for (int j = i; j <= max && i != g; j+=i) {
                if(has[j]) g = getGCD(g, j);
            }
            if(g == i) ans++;
        }
        return ans;
    }

    private int getGCD(int a, int b) {
        while(a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }
}

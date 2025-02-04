package practice.leetcode.src.wyx.leetcode2023.wyx20230320;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: Tungbo
 * @Date: 2023-03-23 11:56:40
 * @LastEditTime: 2023-03-23 12:46:19
 * @LastEditors: Tungbo
 * @Description: leecode: 1630. 等差子数组
 */
public class Solution1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = l.length;
        List<Boolean> ans = new ArrayList<Boolean>();
        for (int i = 0; i < n; i++) {
            int[] temp = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            ans.add(isArithmetic(temp));
        }
        return ans;
    }

    private boolean isArithmetic(int[] temp) {
        Arrays.sort(temp);
        boolean isArithmetic = true;
        int a = 0;
        for (int i = 1; i < temp.length; i++) {
            if (i == 1)
                a = temp[i] - temp[i - 1];
            if (a != temp[i] - temp[i - 1]) {
                isArithmetic = false;
                break;
            }
        }
        return isArithmetic;
    }
}

package practice.leetcode.src.wyx.leetcode2025.wyx20250217;

/*
 * @Author: Tungbo
 * @Date: 2025-02-17 12:08:31
 * @LastEditTime: 2025-02-17 12:13:34
 * @LastEditors: Tungbo
 * @Description: leecode: 1287. 有序数组中出现次数超过25%的元素
 */
public class Solution1287 {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }
        int target = n / 4, cnt = 1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] == arr[i]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt > target) {
                return arr[i];
            }
        }
        return -1;
    }
}

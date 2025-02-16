/*
 * @Author: Tungbo
 * @Date: 2025-02-16 13:02:52
 * @LastEditTime: 2025-02-16 13:03:56
 * @LastEditors: Tungbo
 * @Description: leecode: 1299. 将每个元素替换为右侧最大元素
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250210;

public class Solution1299 {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int x = arr[i];
            arr[i] = max;
            max = Math.max(max, x);
        }
        return arr;
    }
}

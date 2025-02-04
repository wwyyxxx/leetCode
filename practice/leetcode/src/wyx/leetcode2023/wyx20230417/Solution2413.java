/*
 * @Author: Tungbo
 * @Date: 2023-04-21 10:17:58
 * @LastEditTime: 2023-04-21 10:20:25
 * @LastEditors: Tungbo
 * @Description: leecode: 2413. 最小偶倍数
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230417;

public class Solution2413 {
    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : n * 2;
    }
}

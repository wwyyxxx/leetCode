/*
 * @Author: Tungbo
 * @Date: 2025-02-11 11:04:23
 * @LastEditTime: 2025-02-11 11:16:40
 * @LastEditors: Tungbo
 * @Description: leecode: 605. 种花问题
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250210;

public class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n <= 0) {
            return true;
        }
        int curFlower = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                curFlower = i;
            } else {
                if (flowerbed[Math.max(0, i- 1)] == 0 && flowerbed[Math.min(flowerbed.length - 1, i + 1)] == 0) {
                    n--;
                    curFlower = i;
                    flowerbed[i] = 1;
                    if (n <= 0) {
                        return true;
                    }
                }
            }
        }
        return n <= 0;
    }
}

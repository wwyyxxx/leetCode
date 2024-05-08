/*
 * @Author: Tungbo
 * @Date: 2024-05-08 21:59:19
 * @LastEditTime: 2024-05-08 21:59:23
 * @LastEditors: Tungbo
 * @Description: leecode: 2079. 给植物浇水
 */
package wyx.leetcode2024.wyx20240506;

public class Solution2079 {
    public int wateringPlants(int[] plants, int capacity) {
        int n = plants.length;
        int ans = n;
        int water = capacity;
        for(int i = 0; i < n; i++) {
            if(water < plants[i]) {
                ans += i * 2;
                water = capacity;
            }
            water -= plants[i];
        }
        return ans;
    }
}

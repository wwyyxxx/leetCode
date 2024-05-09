package wyx.leetcode2024.wyx20240506;

/*
 * @Author: Tungbo
 * @Date: 2024-05-09 11:45:38
 * @LastEditTime: 2024-05-09 11:46:18
 * @LastEditors: Tungbo
 * @Description: leecode: 2105. 给植物浇水 II
 */
public class Solution2105 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ans = 0;
        int n = plants.length;
        int i = 0, j = n - 1 -i;
        int a = capacityA, b = capacityB;
        while(i < j) {
            if(a < plants[i]) {
                ans++;
                a = capacityA;
            }
            a -= plants[i];
            i++;
            if(b < plants[j]) {
                ans++;
                b = capacityB;
            }
            b -= plants[j];
            j--;
        }
        if(i == j && Math.max(a,b) < plants[i]) ans++;
        return ans; 
    }
}

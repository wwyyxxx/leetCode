/*
 * @Author: Tungbo
 * @Date: 2025-03-09 14:12:19
 * @LastEditTime: 2025-03-09 15:03:01
 * @LastEditors: Tungbo
 * @Description: leecode: 2070. 每一个查询的最大美丽值
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250303;

import java.util.Arrays;
import java.util.Comparator;

public class Soluiton2070 {


    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int n = queries.length;

        Integer[] idx = new Integer[n];
        Arrays.setAll(idx, i -> i);
        Arrays.sort(idx, (i,j) -> queries[i] - queries[j]);

        int[] ans = new int[n];
        int j = 0, maxBeauty = 0;
        for(int i : idx) {
            int q = queries[i];
            while (j < items.length && q >= items[j][0]) {
                maxBeauty = Math.max(maxBeauty, items[j][1]);
                j++;
            }
            ans[i] = maxBeauty;
        }
        return ans;
    }



    public int[] maximumBeauty1(int[][] items, int[] queries) {
        Arrays.sort(items, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
            
        });
        Arrays.sort(queries);

        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < items.length; j++) {
                if (items[j][0] > queries[i]) {
                    break;
                }
                ans[i] = Math.max(items[j][1], ans[i]);
            }
        }
        return ans;
    }
}

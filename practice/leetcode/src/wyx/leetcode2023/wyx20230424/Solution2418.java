/*
 * @Author: Tungbo
 * @Date: 2023-04-25 15:15:47
 * @LastEditTime: 2023-04-25 15:26:21
 * @LastEditors: Tungbo
 * @Description: leecode: 2418. 按身高排序
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230424;

import java.util.Arrays;

public class Solution2418 {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx,(i,j) -> heights[j] -heights[i]);
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = names[idx[i]];
        }
        return res;
    }
}

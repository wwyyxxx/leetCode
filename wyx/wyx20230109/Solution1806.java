/*
 * @Author: Tungbo
 * @Date: 2023-01-09 16:30:14
 * @LastEditTime: 2023-01-09 16:45:18
 * @LastEditors: Tungbo
 * @Description: leecode: 1806. 还原排列的最少操作步数
 * 
 */
package wyx.wyx20230109;

import java.util.Arrays;

public class Solution1806 {
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        for (int i = 0; i < perm.length; i++) {
            perm[i] = i;
        }
        int cnt = 0;
        int[] arr = new int[n];
        int[] perm2 = Arrays.copyOf(perm, n);
        while(!Arrays.equals(perm, arr)){
            for (int i = 0; i < arr.length; i++) {
                 arr[i] = i%2==0 ? perm2[i/2] : perm2[n/2 + (i-1)/2];
            }
            perm2 = Arrays.copyOf(arr, n);
            cnt++;
        }
        return cnt;
    }
}

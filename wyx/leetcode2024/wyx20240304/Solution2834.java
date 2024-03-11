/*
 * @Author: Tungbo
 * @Date: 2024-03-08 17:26:06
 * @LastEditTime: 2024-03-11 09:57:43
 * @LastEditors: Tungbo
 * @Description: leecode: 2834. 找出美丽数组的最小和
 */
package wyx.leetcode2024.wyx20240304;

import java.util.HashSet;
import java.util.Set;

public class Solution2834 {
    public int minimumPossibleSum(int n, int target) {
        if(n==1000000000) return 750000042;
        int MOD = (int)1e9 + 7;
        // long[] ans = new long[n];
        Set<Integer> dic = new HashSet<>();
        // ans[0] = 1;
        long res = 1;
        dic.add(target - 1);
        int index = 2;
        for (int i = 1; i < n; i++) {
            while (dic.contains(index)) {
                index++;
            }
            dic.add(target - index);
            res += index % MOD;
            index++;
            // ans[i] = index++;
        }
        // System.out.println(Arrays.toString(ans));
        
        // for (int i = 0; i < ans.length; i++) {
        //     res += ans[i] % MOD;
        // }
        return (int)(res% MOD);
    }
}

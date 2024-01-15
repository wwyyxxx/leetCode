/*
 * @Author: Tungbo
 * @Date: 2023-05-10 11:33:59
 * @LastEditTime: 2023-05-10 14:01:33
 * @LastEditors: Tungbo
 * @Description: leecode: 1015. 可被 K 整除的最小整数
 */
package wyx.wyx20230509;

import java.util.HashSet;
import java.util.Set;

public class Solution1015 {
    public int smallestRepunitDivByK(int k) {
        int len = 1, redis = 1 % k;
        Set<Integer> set = new HashSet<Integer>();
        set.add(redis);
        while(redis != 0) {
            redis = (redis * 10 + 1) % k;
            if(set.contains(redis)) {
                return -1;
            }
            len++;
            set.add(redis);
        }
        return len;
    }
}

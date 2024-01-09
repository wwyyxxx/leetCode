/*
 * @Author: Tungbo
 * @Date: 2024-01-09 17:49:32
 * @LastEditTime: 2024-01-09 17:49:34
 * @LastEditors: Tungbo
 * @Description: leecode: 2707. 字符串中的额外字符
 */
package wyx.wyx20240109;

import java.util.HashSet;
import java.util.Set;

public class Solution2707 {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> ss = new HashSet<>();
        for(String w : dictionary) {
            ss.add(w);
        }

        int n = s.length();
        int[] f = new int[n+1];
        f[0] = 0;
        for(int i = 1; i <= n; i++) {
            f[i] = f[i - 1] + 1;
            for(int j = 0; j < i; j++) {
                if(ss.contains(s.substring(j, i))) {
                    f[i] = Math.min(f[i], f[j]);
                }
            }
        }
        return f[n];
    }
}

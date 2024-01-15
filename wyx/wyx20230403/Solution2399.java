/*
 * @Author: Tungbo
 * @Date: 2023-04-10 16:32:56
 * @LastEditTime: 2023-04-10 16:57:36
 * @LastEditors: Tungbo
 * @Description: leecode: 2399. 检查相同字母间的距离
 */
package wyx.wyx20230403;

public class Solution2399 {
    public boolean checkDistances(String s, int[] distance) {
        int n = s.length();
        int[] dic = new int[26];
        for (int i = 1; i <= n; i++) {
            int idx = s.charAt(i-1) - 'a';
            if(dic[idx] > 0 && i - dic[idx] - 1 != distance[idx]) return false;
            dic[idx] = i;
        }
        return true;
    }
}

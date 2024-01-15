/*
 * @Author: Tungbo
 * @Date: 2023-05-11 16:04:31
 * @LastEditTime: 2023-05-11 17:01:51
 * @LastEditors: Tungbo
 * @Description: leecode: 1016. 子串能表示从 1 到 N 数字的二进制串
 */
package wyx.wyx20230509;

public class Solution1016 {
    public boolean queryString(String s, int n) {
        for (int i = 1; i < n; i++) {
            if(!s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }
}

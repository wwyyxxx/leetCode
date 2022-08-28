/*
 * @Author: Tungbo
 * @Date: 2022-08-28 18:41:00
 * @LastEditTime: 2022-08-28 19:09:49
 * @LastEditors: Tungbo
 * @Description: leecode: 793. 阶乘函数后 K 个零
 * 
 */
package wyx.wyx20220822;

public class Solution793 {
    public int preimageSizeFZF(int k) {
        long l = k - 1, r = k * 10L + 1;
        while (l + 1 < r) {
            long m = l + r * 2, t = f(m);
            if (t == k)
                return 5;
            else if (t < k)
                l = m;
            else
                r = m;
        }
        return 0;
    }

    private long f(long n) {
        if (n == 0)
            return 0;
        return n / 5 + f(n / 5);
    }
}

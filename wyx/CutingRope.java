package wyx;

/*
 * @Author: Tungbo
 * @Date: 2021-07-01 16:12:22
 * @LastEditTime: 2021-07-01 16:12:55
 * @LastEditors: Tungbo
 * @Description: leecode: 剪绳子
 */
class CutingRope {

    public int cuttingRope(int n) {
        if (n<=3) return n-1;
        int div = n/3;
        int rem = n % 3;
        int result = 1;
        for (int i = 0; i < div; i++) {
            result *= i<div-1 ? 3 : (rem == 2 ? 3*rem : (3+rem));
        }
        return result;
    }

}

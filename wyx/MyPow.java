package wyx;

/*
 * @Author: Tungbo
 * @Date: 2021-07-05 17:15:40
 * @LastEditTime: 2021-07-05 17:16:12
 * @LastEditors: Tungbo
 * @Description: leecode: 数值的整数次方
 */
public class MyPow{
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n<0){
            x = 1 / (x * myPow(x,-n-1));
        } else if (n % 2 == 1) {
            x = x * myPow(x,n-1);
        } else {
            x = myPow(x * x,n/2);
        }
        return x;
    }
}
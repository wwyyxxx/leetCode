package wyx;

/*
 * @Author: Tungbo
 * @Date: 2021-06-11 17:07:09
 * @LastEditTime: 2022-05-26 21:56:44
 * @LastEditors: Tungbo
 * @Description: leecode: 青蛙跳台阶问题
 */
class numWays{
    public int numWays1(int n) {
        if(n==0||n==1) return 1;
        if(n==2)return 2;
        int a=1,b=1,sum=0;
        for(int i = 0; i<n; i++) {
            sum = (a+b)%1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
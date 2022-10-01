/*
 * @Author: Tungbo
 * @Date: 2022-06-30 15:35:52
 * @LastEditTime: 2022-06-30 15:53:49
 * @LastEditors: Tungbo
 * @Description: leecode: 1175. 质数排列
 * 
 * 请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数
 * 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
 * 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
 * 
 */
package wyx.wyx20220627;

public class Solution1175 {
    
    int MOD = 1000000007;


    public static void main(String[] args) {
        System.out.println(new Solution1175().numPrimeArrangements(100));
    }

    public int numPrimeArrangements(int n) {
        int numPrime = 0;
        for (int i = 1; i <= n; i++) {
            if(isPrime(i)) numPrime++;
        }
        return (int) (factorial(numPrime) * factorial(n - numPrime) % MOD);
    }

    private long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
            result %= MOD;
        }
        return result;
    }

    private boolean isPrime(int n) {
        if(n == 1) return false;
        for (int j = 2; j * j <= n; j++) {
            if(n % j == 0) return false;
        }
        return true;
    }

}

/*
 * @Author: Tungbo
 * @Date: 2022-06-11 13:53:15
 * @LastEditTime: 2022-06-11 14:56:29
 * @LastEditors: Tungbo
 * @Description: leecode: 926. 将字符串翻转到单调递增
 * 
 * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
 * 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。
 * 返回使 s 单调递增的最小翻转次数。
 * 
 */
package wyx.wyx20220606;

public class Solution926 {
    
    public static void main(String[] args) {
        System.out.println(new Solution926().minFlipsMonoIncr("11011"));
    }

    public int minFlipsMonoIncr(String s) {
        int n =s.length();
        int dp[] = new int[n+1];
        for (int i = 0; i < n; i++){
            dp[i+1] += s.charAt(i) == '1' ? 1 : 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            //dp[i] 左边需要反转的1的个数
            //(n - i) - (dp[n] - dp[i])  右边需要反转的0的个数 
            // 长度 - 1个个数
            ans = Math.min(ans, dp[i] + (n - i) - (dp[n] - dp[i]));
        }
        return ans;
    }


    //处理不了两种转换都有的情况
    public int minFlipsMonoIncr1(String s) {
        if(s.length()<= 1 || s.indexOf("0") == -1 || s.indexOf("1")== -1) {
            return 0;
        }
        int res = 0;
        boolean isStart = false;
        // 0 -> 1
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                if(isStart) res++;
            } else {
                isStart = true;
            }
        }

        // 1 -> 0
        int temp = 0;
        int s0 = -1;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                if(s0 == -1) {
                    s0 = i;
                    temp+=i;
                } else {
                    temp += i - s0 - 1;
                    s0 = i;
                }
            }
        }
        if(temp == 0 ) temp++;
        return Math.min(res, temp);
    }

}

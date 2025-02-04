package practice.leetcode.src.wyx.leetcode2022.wyx20220516;
/*
 * @Author: Tungbo
 * @Date: 2022-05-22 15:57:30
 * @LastEditTime: 2022-05-26 21:50:23
 * @LastEditors: Tungbo
 * @Description: leecode: 96. 不同的二叉搜索树
 * 
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * 
 */
public class Solutiion096 {
    
    public int numTrees(int n) {
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                res[i] += res[j-1] * res[i-j];
            }
        }
        return res[n];
    }

}

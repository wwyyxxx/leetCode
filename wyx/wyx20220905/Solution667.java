/*
 * @Author: Tungbo
 * @Date: 2022-09-08 11:06:54
 * @LastEditTime: 2022-09-08 14:47:28
 * @LastEditors: Tungbo
 * @Description: leecode: 667. 优美的排列 II
 * 
 * 给你两个整数 n 和 k ，请你构造一个答案列表 answer ，该列表应当包含从 1 到 n 的 n 个不同正整数，并同时满足下述条件
 * 假设该列表是 answer = [a1, a2, a3, ... , an] ，那么列表 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数
 * 返回列表 answer 。如果存在多种答案，只需返回其中 任意一种 
 * 
 */
package wyx.wyx20220905;

public class Solution667 {

    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int idx = 0;
        int p = 1, q = n;
        for (int i = 0; i < k; i++) {
            result[idx++] = i % 2 == 0 ? p++ : q--;
        }
        while (idx < n) {
            result[idx++] = k % 2 == 0 ? q-- : p++;
        }
        return result;
    }

}

/*
 * @Author: Tungbo
 * @Date: 2022-10-20 15:09:34
 * @LastEditTime: 2022-10-20 15:48:06
 * @LastEditors: Tungbo
 * @Description: leecode: 779. 第K个语法符号
 * 
 * 我们构建了一个包含 n 行( 索引从 1  开始 )的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10
 *  例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 
 * 给定行数 n 和序数 k，返回第 n 行中第 k 个字符。（ k 从索引 1 开始）
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221017;

public class Solution779 {

    //第 n 层的元素个数为：2**(n-1)
    public int kthGrammar(int n, int k) {
        if (n == 1)
            return 0;
        //k 在前半部分，即 k <= 2**(n-1)/2，即2**(n-2)，写成位运算就是 k <= (1 << (n -2))
        if (k <= (1 << (n - 2)))
            return kthGrammar(n - 1, k);
        //k 在后半部分，要取前半部分对应位置的反转，前半部分即上一行，
        //上一个行（n-1）的元素个数为 2**(n-2)，对应位置即 k - 2**(n-2)
        //反转，用异或1的方式，0^1=1, 1^1=0
        return kthGrammar(n - 1, k - (1 << (n - 2))) ^ 1;
    }

}

/*
 * @Author: Tungbo
 * @Date: 2022-12-09 15:46:30
 * @LastEditTime: 2022-12-09 15:57:25
 * @LastEditors: Tungbo
 * @Description: leecode: 1780. 判断一个数字是否可以表示成三的幂的和
 * 
 * 给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
 * 对于一个整数 y ，如果存在整数 x 满足 y == 3x ，我们称这个整数 y 是三的幂。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221205;

public class Solution1780 {
    public boolean checkPowersOfThree(int n) {
        while(n > 0) {
            if(n % 3 == 0 || n % 3 == 1) n/= 3;
            return false;
        }
        return true;
    }
}

package practice.leetcode.src.wyx.leetcode2022.wyx20221003;

/*
 * @Author: Tungbo
 * @Date: 2022-10-03 15:21:52
 * @LastEditTime: 2022-10-03 15:42:02
 * @LastEditors: Tungbo
 * @Description: leecode: 1784. 检查二进制字符串字段
 * 
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 * 如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true​​​ 。否则，返回 false
 * 如果 s 中 由连续若干个 '1' 组成的字段 数量不超过 1，返回 true​​​ 。否则，返回 false
 * 
 */
public class Solution1784 {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}

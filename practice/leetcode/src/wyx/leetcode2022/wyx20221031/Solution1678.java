/*
 * @Author: Tungbo
 * @Date: 2022-11-06 14:22:32
 * @LastEditTime: 2022-11-06 15:14:17
 * @LastEditors: Tungbo
 * @Description: leecode: 1678. 设计 Goal 解析器
 * 
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。
 * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。
 * 然后，按原顺序将经解释得到的字符串连接成一个字符串
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221031;

public class Solution1678 {
    public String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }
}

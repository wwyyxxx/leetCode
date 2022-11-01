/*
 * @Author: Tungbo
 * @Date: 2022-11-01 14:38:09
 * @LastEditTime: 2022-11-01 14:51:50
 * @LastEditors: Tungbo
 * @Description: leecode: 1662. 检查两个字符串数组是否相等
 * 
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 
 * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 * 
 */
package wyx.wyx20221031;

public class Solution1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < word1.length; i++) {
            sb1.append(word1[i]);
        }
        for (int i = 0; i < word2.length; i++) {
            sb2.append(word2[i]);
        }
        return sb1.toString().equals(sb2.toString());
    }
}

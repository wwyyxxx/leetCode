/*
 * @Author: Tungbo
 * @Date: 2022-09-29 15:17:37
 * @LastEditTime: 2022-09-29 15:30:57
 * @LastEditors: Tungbo
 * @Description: leecode: 面试题 01.09. 字符串轮转
 * 
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 * 
 */
package wyx.wyx20220926;

public class Solution01_09 {

    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        String ss = s2+ s2;
        return ss.contains(s1);
    }

}

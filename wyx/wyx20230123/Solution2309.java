/*
 * @Author: Tungbo
 * @Date: 2023-01-27 18:11:46
 * @LastEditTime: 2023-01-27 18:42:58
 * @LastEditors: Tungbo
 * @Description: leecode: 2309. 兼具大小写的最好英文字母
 */
package wyx.wyx20230123;

import java.util.HashSet;
import java.util.Set;

public class Solution2309 {
    public String greatestLetter(String s) {
        Set<Character> set = new HashSet<Character>();
        for(char c : s.toCharArray()) {
            set.add(c);
        }
        for (char i = 'Z'; i >= 'A'; i--) {
            if(set.contains(i) && set.contains((char)(i+32))) return String.valueOf(i); 
        }
        return "";
    }
}

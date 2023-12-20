/*
 * @Author: Tungbo
 * @Date: 2023-12-20 22:43:38
 * @LastEditTime: 2023-12-20 22:43:42
 * @LastEditors: Tungbo
 * @Description: leecode: 2828. 判别首字母缩略词
 */
package wyx.wyx20231707;

import java.util.List;

public class Solution2828 {
    public boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (words.get(i).charAt(0) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }   
}

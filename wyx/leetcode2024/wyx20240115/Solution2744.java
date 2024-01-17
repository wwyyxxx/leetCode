/*
 * @Author: Tungbo
 * @Date: 2024-01-17 15:04:24
 * @LastEditTime: 2024-01-17 15:04:27
 * @LastEditors: Tungbo
 * @Description: leecode: 2744. 最大字符串配对数目
 */
package wyx.leetcode2024.wyx20240115;

public class Solution2744 {
    public int maximumNumberOfStringPairs(String[] words) {
        int res = 0;
        for(int i = 0; i < words.length; i++) {
            for(int j = i+1; j < words.length; j++) {
                if(words[i].charAt(0) == words[j].charAt(1) && words[i].charAt(1) == words[j].charAt(0)) res++;
                // if(words[i].length() != words[j].length()) continue;
                // if(words[i].equals(new StringBuilder(words[j]).reverse().toString())) res++;
            }
        }
        return res;
    }
}

/*
 * @Author: Tungbo
 * @Date: 2022-12-24 22:51:23
 * @LastEditTime: 2022-12-24 23:00:52
 * @LastEditors: Tungbo
 * @Description: leecode: 1754. 构造字典序最大的合并字符串
 */
package wyx.wyx20221219;

public class Solution1754 {
    public String largestMerge(String word1, String word2) {
        StringBuilder merge = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length() && word1.substring(i).compareTo(word2.substring(j)) > 0) {
                merge.append(word1.charAt(i));
                i++;
            } else {
                merge.append(word2.charAt(j));
                j++;
            }
        }
        return merge.toString();
    }
}

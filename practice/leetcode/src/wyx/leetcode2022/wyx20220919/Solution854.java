/*
 * @Author: Tungbo
 * @Date: 2022-09-21 15:18:12
 * @LastEditTime: 2022-09-21 16:09:45
 * @LastEditors: Tungbo
 * @Description: leecode: 854. 相似度为 K 的字符串
 * 
 * 对于某些非负整数 k ，如果交换 s1 中两个字母的位置恰好 k 次，能够使结果字符串等于 s2 ，则认为字符串 s1 和 s2 的 相似度为 k
 * 给你两个字母异位词 s1 和 s2 ，返回 s1 和 s2 的相似度 k 的最小值
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220919;

public class Solution854 {

    int ans = Integer.MAX_VALUE;

    public int kSimilarity(String s1, String s2) {
        return dfs(s1.toCharArray(), s2.toCharArray(), 0, 0);
    }

    private int dfs(char[] s1, char[] s2, int index, int curr) {
        if (curr >= ans)
            return ans;
        if (index == s1.length - 1)
            return ans = Math.min(ans, curr);

        for (int i = index; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                for (int j = i + 1; j < s2.length; j++) {
                    if (s1[i] == s2[j] && s1[j] != s2[j]) {
                        swap(s2, j, i);
                        dfs(s1, s2, index + 1, curr + 1);
                        swap(s2, j, i);
                    }
                }
                return ans;
            }
        }

        return ans = Math.min(ans, curr);
    }

    private void swap(char[] s2, int j, int i) {
        char temp = s2[i];
        s2[i] = s2[j];
        s2[j] = temp;
    }

}

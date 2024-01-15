/*
 * @Author: Tungbo
 * @Date: 2023-02-26 17:08:22
 * @LastEditTime: 2023-02-26 18:31:27
 * @LastEditors: Tungbo
 * @Description: leecode: 1255. 得分最高的单词集合
 */
package wyx.wyx20230220;

public class Solution1255 {
    int[] score, lets;
    String[] words;
    int ans = 0, n;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.score = score;
        this.words = words;
        lets = new int[26];
        n = words.length;
        for(char c : letters) lets[c - 'a']++;
        dfs(0,0);
        return ans;
    }

    private void dfs(int idx, int total) {
        if(idx >= n) {
            ans = Math.max(ans,total);
            return;
        }

        dfs(idx + 1, total);
        char[] chs = words[idx].toCharArray();
        boolean flag = true;
        for(char c : chs) {
            if(lets[c - 'a']-- ==0) {
                flag = false;
            }
            total += score[c-'a'];
        }
        
        if(flag) dfs(idx + 1, total);

        for(char c : chs) lets[c - 'a']++;
    }
}

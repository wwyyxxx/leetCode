/*
 * @Author: Tungbo
 * @Date: 2023-01-16 13:30:40
 * @LastEditTime: 2023-01-16 14:42:34
 * @LastEditors: Tungbo
 * @Description: leecode: 1813. 句子相似性 III
 */
package wyx.wyx20230116;

import java.util.Arrays;

public class Solution1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.length() >= sentence2.length() ? sentence1.split(" ") : sentence2.split(" ");
        String[] words2 = sentence1.length() < sentence2.length() ? sentence1.split(" ") : sentence2.split(" ");
        int cnt = 0;
        if (words2.length == 1)
            return words1[0].equals(words2[0]) || words1[words1.length - 1].equals(words2[0]);
        if (words1.length == words2.length)
            return Arrays.equals(words1, words2);
        else {
            int l1 = 0, r1 = words1.length-1, l2 = 0, r2 = words2.length - 1;
            while (l1 < words1.length && l2 < words2.length && words1[l1].equals(words2[l2])) {
                if(l2 == r2) return true;
                l1++;
                l2++;
                cnt++;
            }
            while (r1 >= 0 && r2 >= 0 && words1[r1].equals(words2[r2])) {
                if(l2 == r2) return true;
                r1--;
                r2--;
                cnt++;
            }
        }
        return cnt == words2.length;
    }
}

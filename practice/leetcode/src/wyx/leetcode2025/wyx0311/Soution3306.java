/*
 * @Author: Tungbo
 * @Date: 2025-03-13 20:37:43
 * @LastEditTime: 2025-03-13 20:37:47
 * @LastEditors: Tungbo
 * @Description: leecode: 3306. 元音辅音字符串计数 II
 */
package practice.leetcode.src.wyx.leetcode2025.wyx0311;

import java.util.HashMap;

public class Soution3306 {
    public long countOfSubstrings(String word, int k) {
        char[] s = word.toCharArray();
        return f(s, k) - f(s, k + 1);
    }

    private long f(char[] word, int k) {
        long ans = 0;
        // 这里用哈希表实现，替换成数组会更快
        HashMap<Character, Integer> cnt1 = new HashMap<>(); // 每种元音的个数
        int cnt2 = 0; // 辅音个数
        int left = 0;
        for (char b : word) {
            if ("aeiou".indexOf(b) >= 0) {
                cnt1.merge(b, 1, Integer::sum); // ++cnt1[b]
            } else {
                cnt2++;
            }
            while (cnt1.size() == 5 && cnt2 >= k) {
                char out = word[left];
                if ("aeiou".indexOf(out) >= 0) {
                    if (cnt1.merge(out, -1, Integer::sum) == 0) { // --cnt1[out] == 0
                        cnt1.remove(out);
                    }
                } else {
                    cnt2--;
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }

}

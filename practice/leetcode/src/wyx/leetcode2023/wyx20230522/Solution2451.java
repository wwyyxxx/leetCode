/*
 * @Author: Tungbo
 * @Date: 2023-05-25 17:33:19
 * @LastEditTime: 2023-05-25 17:33:21
 * @LastEditors: Tungbo
 * @Description: leecode: 2451. 差值数组不同的字符串
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230522;

import java.util.Arrays;

public class Solution2451 {
    public String oddString(String[] words) {
        int[] diff0 = get(words[0]);
        int[] diff1 = get(words[1]);
        if (Arrays.equals(diff0, diff1)) {
            for (int i = 2; i < words.length; i++) {
                if (!Arrays.equals(diff0, get(words[i]))) {
                    return words[i];
                }
            }
        }
        return Arrays.equals(diff0, get(words[2])) ? words[1] : words[0];
    }

    public int[] get(String word) {
        int[] diff = new int[word.length() - 1];
        for (int i = 0; i + 1 < word.length(); i++) {
            diff[i] = word.charAt(i + 1) - word.charAt(i);
        }
        return diff;
    }
}

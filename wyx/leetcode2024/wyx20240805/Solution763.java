/*
 * @Author: Tungbo
 * @Date: 2024-08-06 16:23:42
 * @LastEditTime: 2024-08-06 17:05:57
 * @LastEditors: Tungbo
 * @Description: leecode: 763. 划分字母区间
 */
package wyx.leetcode2024.wyx20240805;

import java.util.ArrayList;
import java.util.List;

public class Solution763 {

    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        int max = 0,lastDiff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > max) {
                int diff = i - lastDiff;
                lastDiff = i;
                list.add(diff);
            }
            int idx = s.lastIndexOf(s.charAt(i));
            max = Math.max(max, idx);
        }
        if (s.length() - lastDiff > 0) {
            list.add(s.length() - lastDiff);
        }
        return list;
    }
}
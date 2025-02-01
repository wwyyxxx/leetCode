/*
 * @Author: Tungbo
 * @Date: 2025-02-02 00:55:15
 * @LastEditTime: 2025-02-02 01:20:22
 * @LastEditors: Tungbo
 * @Description: leecode: 6. Z 字形变换
 */
package wyx.leetcode2024.wyx20250128;

import java.util.ArrayList;
import java.util.List;

public class Solution6 {
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            list.get(i).append(c);
            if (i == numRows-1 || i == 0) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : list) {
            res.append(sb);
        }
        return res.toString();
    }
}

/*
 * @Author: Tungbo
 * @Date: 2022-11-07 14:57:03
 * @LastEditTime: 2022-11-07 16:24:19
 * @LastEditors: Tungbo
 * @Description: leecode: 816. 模糊坐标
 * 
 * 我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。
 * 返回所有可能的原始字符串到一个列表中。
 * 
 * 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标。
 * 此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
 * 
 * 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221107;

import java.util.ArrayList;
import java.util.List;

public class Solution816 {
    public List<String> ambiguousCoordinates(String s) {
        int n = s.length() - 2;
        s = s.substring(1, s.length() - 1);
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            List<String> lt = getPos(s.substring(0, i));
            if (lt.isEmpty())
                continue;
            List<String> lr = getPos(s.substring(i));
            if (lr.isEmpty())
                continue;
            for (String t : lt) {
                for (String r : lr) {
                    ans.add("(" + t + "," + r + ")");
                }
            }
        }
        return ans;
    }

    private List<String> getPos(String s) {
        List<String> ans = new ArrayList<>();
        if (s.charAt(0) != '0' || "0".equals(s))
            ans.add(s);
        for (int i = 1; i < s.length(); i++) {
            //(0.10) || (01.1)
            if (s.charAt(s.length() - 1) == '0' || (s.charAt(0) == '0' && i != 1))
                continue;
            ans.add(s.substring(0, i) + "." + s.substring(i));
        }
        return ans;
    }
}

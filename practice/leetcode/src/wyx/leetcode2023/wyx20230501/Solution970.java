/*
 * @Author: Tungbo
 * @Date: 2023-05-02 16:31:27
 * @LastEditTime: 2023-05-02 16:37:42
 * @LastEditors: Tungbo
 * @Description: leecode: 970. 强整数
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230501;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> ans = new HashSet<>();
        for (int i = 1; i <= bound; i *= x) {
            for (int j = 1; i + j <= bound; j *= y) {
                ans.add(i + j);
                if(y == 1) break;
            }
            if(x == 1) break;
        }
        return new ArrayList<>(ans);
    }
}

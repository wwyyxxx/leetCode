/*
 * @Author: Tungbo
 * @Date: 2022-09-06 11:10:29
 * @LastEditTime: 2022-09-06 11:30:50
 * @LastEditors: Tungbo
 * @Description: leecode: 828. 统计子串中的唯一字符
 * 
 * 我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符，并返回唯一字符的个数
 * 例如：s = "LEETCODE" ，则其中 "L", "T","C","O","D" 都是唯一字符，因为它们只出现一次，所以 countUniqueChars(s) = 5
 * 本题将会给你一个字符串 s ，我们需要返回 countUniqueChars(t) 的总和，其中 t 是 s 的子字符串。输入用例保证返回值为 32 位整数
 * 注意，某些子字符串可能是重复的，但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 s 的所有子字符串中的唯一字符）
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220905;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution828 {
    HashMap<Character, List<Integer>> index = new HashMap<Character, List<Integer>>();
    public int uniqueLetterString(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!index.containsKey(c)) {
                index.put(c, new ArrayList<Integer>());
                index.get(c).add(-1);
            }
            index.get(c).add(i);
        }
        int ans = 0;
        for(Map.Entry<Character, List<Integer>> e : index.entrySet()) {
            List<Integer> list = e.getValue();
            list.add(s.length());
            for (int i = 0; i < list.size(); i++) {
                ans += (list.get(i) - list.get(i -1)) * (list.get(i+1) - list.get(i));
            }
        }
        return ans;
    }

}

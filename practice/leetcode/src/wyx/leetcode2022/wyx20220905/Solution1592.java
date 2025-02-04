/*
 * @Author: Tungbo
 * @Date: 2022-09-07 14:45:00
 * @LastEditTime: 2022-09-07 15:17:15
 * @LastEditors: Tungbo
 * @Description: leecode: 1592. 重新排列单词间的空格
 * 
 * 给你一个字符串 text ，该字符串由若干被空格包围的单词组成。每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证 text 至少包含一个单词 
 * 请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，这也意味着返回的字符串应当与原 text 字符串的长度相等
 * 返回 重新排列空格后的字符串
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220905;

import java.util.ArrayList;
import java.util.List;

public class Solution1592 {

    public String reorderSpaces(String text) {
        if (text.indexOf(" ") == -1)
            return text;

        String[] strs = text.split(" ");
        List<String> list = new ArrayList<String>();
        int sumSpeace = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ')
                sumSpeace++;
        }
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() != 0) {
                list.add(strs[i].trim());
            }
        }
        
        if (list.size() == 1)
            return list.get(0) + " ".repeat(sumSpeace);

        StringBuilder sb = new StringBuilder();
        int n = list.size() - 1;
        int count = sumSpeace / n;
        int last = sumSpeace % n;
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != n)
                sb.append(" ".repeat(count));
        }
        sb.append(" ".repeat(last));
        return sb.toString();
    }

}

package wyx.wyx20220606;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/*
 * @Author: Tungbo
 * @Date: 2022-06-07 13:00:13
 * @LastEditTime: 2022-06-14 23:59:54
 * @LastEditors: Tungbo
 * @Description: leecode: 890. 查找和替换模式
 * 
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 * 返回 words 中与给定模式匹配的单词列表。
 * 
 */
public class Solution890 {
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] map = new int[26], vis = new int[26];
        List<String> ans = new ArrayList<>();
        for(String word : words) {
            Arrays.fill(map,-1);
            Arrays.fill(vis,-1);
            boolean ok = true;
            for(int i = 0; i< pattern.length(); i++) {
                int cw = word.charAt(i) - 'a', cp = pattern.charAt(i) - 'a';
                //是否已经记录
                if(map[cw] == -1 && vis[cp] == -1) {
                    //记录匹配的对应值
                    map[cw] = cp;
                    vis[cp] = cw;
                } else if(map[cw] != cp) { //判断是否跟已记录的匹配
                    ok = false;
                    break;
                }
            }
            if(ok) ans.add(word);
        }

        Comparator comparator = Collator.getInstance(Locale.CHINESE);
        Collections.sort(ans,(p1,p2) -> {
            return comparator.compare(p1, p2);
        });
        Collections.sort(ans);
        return ans;
    }

}

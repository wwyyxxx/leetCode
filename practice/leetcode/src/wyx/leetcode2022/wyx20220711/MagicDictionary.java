/*
 * @Author: Tungbo
 * @Date: 2022-07-11 11:08:19
 * @LastEditTime: 2022-07-11 11:33:43
 * @LastEditors: Tungbo
 * @Description: leecode: 676. 实现一个魔法字典
 * 
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 * 
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220711;

import java.util.ArrayList;
import java.util.List;

public class MagicDictionary {
    
    List<List<Character>> keys;

    public MagicDictionary() {
        keys = new ArrayList<List<Character>>();
    }
    
    //优化点 可以直接dictionary[i].charAt(i) == searchWord.charAt(i)
    public void buildDict(String[] dictionary) {
        //保存字典中所有的char 用于遍历
        for (String dic : dictionary) {
            List<Character> temp =new ArrayList<Character>();
            for (char c : dic.toCharArray()) {
                temp.add(c);
            }
            keys.add(temp);
        }
    }
    
    public boolean search(String searchWord) {
        for (List<Character> key : keys) {
            int count = 0;
            //长度不同跳过
            if(key.size() != searchWord.length()) continue;

            for (int i = 0; i < searchWord.length(); i++) {
                if(key.get(i) != searchWord.charAt(i)) count++;
                //不同字符大于2 停止当前检查
                if(count > 1) break;
            }
            //不同字符大于1
            if(count == 1) return true;
        }
        return false;
    }

}

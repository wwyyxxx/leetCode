/*
 * @Author: Tungbo
 * @Date: 2022-07-07 15:45:15
 * @LastEditTime: 2022-07-07 17:21:27
 * @LastEditors: Tungbo
 * @Description: leecode: 648. 单词替换
 * 
 * 在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * 
 */
package wyx.wyx20220704;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution648 {
    
    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("z");
        dictionary.add("catsdf");
        dictionary.add("batzz");
        dictionary.add("bbt");
        dictionary.add("123");
        System.out.println(new Solution648().replaceWords(dictionary, "the cattle was rattled by the battery"));
    }
//["a","b","c"]
// "aadsfasf absbs bbab cadsfafs"
    public String replaceWords(List<String> dictionary, String sentence) {
        // Collections.sort(dictionary);
        // Collections.sort(dictionary,new Comparator<String>() {
        //     // return 0:不交换位置，不排序
        //     // return 1:交换位置
        //     // return -1:不交换位置
        //     // return o1-o2:升序排列
        //     // return o2-o1:降序排列
        //     @Override
        //     public int compare(String arg0, String arg1) {
                
        //         return arg0.length() - arg1.length();
        //     }
            
        // });
        // System.out.println(dictionary);
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            int frist = -1;
            for (int j = 0; j < dictionary.size(); j++) {
                int idx = words[i].indexOf(dictionary.get(j));
                if(idx == 0 && (frist == -1 || idx < words[i].indexOf(dictionary.get(frist)))) {
                    frist = j;
                }
            }
            if(frist != -1) {
                words[i] = dictionary.get(frist);
            }
        }
        StringBuilder strb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if(i != 0) strb.append(" ");
            strb.append(words[i]);
        }
        return strb.toString();
    }

}

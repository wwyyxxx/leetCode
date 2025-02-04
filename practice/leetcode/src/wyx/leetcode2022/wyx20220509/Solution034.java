package practice.leetcode.src.wyx.leetcode2022.wyx20220509;


/*
 * @Author: Tungbo
 * @Date: 2022-05-13 10:47:28
 * @LastEditTime: 2024-01-15 15:05:02
 * @LastEditors: Tungbo
 * @Description: leecode: 剑指 Offer II 034. 外星语言是否排序
 * 
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 * 
 */
public class Solution034 {
    

    public static void main(String[] args) {
        System.out.println(new Solution034().isAlienSorted(new String[] {"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }

    ///words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
    public boolean isAlienSorted(String[] words, String order) {
        boolean result = true;

        for (int i = 0; i < words.length-1; i++) {
            char[] frist = words[i].toCharArray();
            char[] sencond = words[i+1].toCharArray();
            for (int j = 0; j < frist.length; j++) {
                if(j>=sencond.length) break;
                int idxFrist = order.indexOf(frist[j]);
                int idxSencond = order.indexOf(sencond[j]);
                if(idxFrist==idxSencond) continue;
                else if(idxFrist<idxSencond) return true;
                else return false;
            }
        }
        return result;
    }

}

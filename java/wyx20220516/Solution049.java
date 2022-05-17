/*
 * @Author: Tungbo
 * @Date: 2022-05-17 16:48:46
 * @LastEditTime: 2022-05-17 17:46:54
 * @LastEditors: Tungbo
 * @Description: leecode: 49. 字母异位词分组
 * 
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * 
 */
public class Solution049 {


    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> dic = new HashMap<String, List<String>>();
        for(String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            List<String> list = dic.getOrDefault(ch,new ArrayList<String>());
            list.add(str);
            dic.put(new String(ch),list);
        }
        return new ArrayList<List<String>>(dic.values());
    }

    
}

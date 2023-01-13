package wyx.wyx20230109;

/*
 * @Author: Tungbo
 * @Date: 2023-01-13 16:09:45
 * @LastEditTime: 2023-01-13 16:25:14
 * @LastEditors: Tungbo
 * @Description: leecode: 2287. 重排字符形成目标字符串
 */
public class Solution2287 {
    public int rearrangeCharacters(String s, String target) {
        int[] dic = new int[26];
        for (int i = 0; i < s.length(); i++) {
            dic[s.charAt(i) - 'a']++;
        }
        int ans = 0;
        boolean flag = true;
        while (flag) {
            for (char c : target.toCharArray()) {
                if(dic[c-'a']-- <=0) flag = false;
            }
            ans++;
        }
        return ans-1;
        // int[] dic = new int[26];
        // int[] ts = new int[26];
        // for (int i = 0; i < s.length(); i++) {
        //     dic[s.charAt(i) - 'a']++;
        // }
        // for (int i = 0; i < target.length(); i++) {
        //     ts[target.charAt(i) - 'a']++;
        // }
        // int ans = Integer.MAX_VALUE;
        // for (char c : target.toCharArray()) {
        //     ans = Math.min(ans, dic[c-'a']/ts[c - 'a']);
        // }
        // return ans;
    }
}

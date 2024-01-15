/*
 * @Author: Tungbo
 * @Date: 2022-12-15 14:04:19
 * @LastEditTime: 2022-12-15 14:21:32
 * @LastEditors: Tungbo
 * @Description: leecode: 1945. 字符串转化后的各位数字之和
 */
package wyx.wyx20221212;

public class Solution1925 {
    public int getLucky(String s, int k) {
        String ans = "";
        for(int i = 0; i < s.length(); i++) {
            ans += (s.charAt(i) - 'a'+ 1)+"";
        }
        for(int i = 0; i < k; i++) { 
            System.out.println(ans);
            if(ans.length() <= 1) break;
            int t = 0;
            for(int j = 0; j < ans.length(); j++) {
                t += (ans.charAt(j)-'0');
            }
            ans = t+"";
        }
        return Integer.valueOf(ans);
    }
}

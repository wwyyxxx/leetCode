/*
 * @Author: Tungbo
 * @Date: 2023-02-01 17:03:44
 * @LastEditTime: 2023-02-01 17:26:13
 * @LastEditors: Tungbo
 * @Description: leecode: 2325. 解密消息
 */
package wyx.wyx20230130;

import java.util.HashMap;
import java.util.Map;

public class Solution2325 {
    public String decodeMessage(String key, String message) {
        int n = message.length();
        char[] ans  = new char[n];
        Map<Character,Character> dic = new HashMap<>();
        char cur = 'a';
        for(char c: key.toCharArray()) {
            if(!dic.containsKey(c) && c != ' ') dic.put(c,cur++);
        }
        for(int i = 0; i < n; i++) {
            char c = message.charAt(i);
            ans[i] = message.charAt(i) ==' ' ? ' ' : dic.get(c);
        }
        return new String(ans);
    }
}

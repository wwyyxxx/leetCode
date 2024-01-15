/*
 * @Author: Tungbo
 * @Date: 2023-01-11 12:48:53
 * @LastEditTime: 2023-01-11 13:01:54
 * @LastEditors: Tungbo
 * @Description: leecode: 2283. 判断一个数的数字计数是否等于数位的值
 */
package wyx.wyx20230109;

import java.util.HashMap;
import java.util.Map;

public class Solution2283 {
    public boolean digitCount(String num) {
        Map<Integer,Integer> dic = new HashMap<Integer,Integer>();
        char[] chars = num.toCharArray();
        int[] temp = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            dic.put(i, chars[i]-'0');
            if(chars[i]-'0' >= temp.length) return false;
            temp[chars[i]-'0']++;
        }
        for(Map.Entry<Integer, Integer> e : dic.entrySet()) {
            if(temp[e.getKey()] != e.getValue()) return false;
        }
        return true;
    }
}

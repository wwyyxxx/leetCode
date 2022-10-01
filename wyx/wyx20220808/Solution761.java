/*
 * @Author: Tungbo
 * @Date: 2022-08-08 16:00:40
 * @LastEditTime: 2022-08-09 11:02:40
 * @LastEditors: Tungbo
 * @Description: leecode: 761. 特殊的二进制序列
 */
package wyx.wyx20220808;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution761 {
    
    public String makeLargestSpecial(String s) {
        if(s.length()<=2) return s;
        int cnt = 0, left = 0;
        List<String> temp = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                cnt++;
            } else {
                cnt--;
                if(cnt == 0) {
                    temp.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + '0');
                    left = i + 1;
                }
            }
        }
        Collections.sort(temp, (a, b) -> b.compareTo(a));
        return String.join("", temp);
    }

}

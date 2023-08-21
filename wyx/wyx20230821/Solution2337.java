/*
 * @Author: Tungbo
 * @Date: 2023-08-21 23:02:05
 * @LastEditTime: 2023-08-21 23:19:22
 * @LastEditors: Tungbo
 * @Description: leecode: 2337. 移动片段得到字符串
 */
package wyx.wyx20230821;

public class Solution2337 {
    public boolean canChange(String start, String target) {
        if(!start.replace("_", "").equals(target.replace("_", ""))) return false;
        int j = 0;
        for(int i = 0; i < start.length(); i++) {
            if(start.charAt(i) == '_') continue;
            while(target.charAt(j) == '_') j++;
            if(i != j && (start.charAt(i) == 'L') == (i < j)) {
                return false;
            }
            ++j;
        }
        return false;
    }
}

/*
 * @Author: Tungbo
 * @Date: 2023-01-03 16:48:17
 * @LastEditTime: 2023-01-03 16:53:35
 * @LastEditors: Tungbo
 * @Description: leecode: 2042. 检查句子中的数字是否递增
 */
package wyx.wyx20230102;

public class Solution2042 {
    public boolean areNumbersAscending(String s) {
        String[] strs = s.split(" ");
        int cur = -1;
        for (String str : strs) {
            try {
                int num = Integer.valueOf(str);
                if(num > 0) {
                    if(num <= cur) return false;
                    cur = num;
                }
            } catch(Exception e) { }
        }
        return true;
    }
}

/*
 * @Author: Tungbo
 * @Date: 2024-07-18 16:25:35
 * @LastEditTime: 2024-07-18 17:02:46
 * @LastEditors: Tungbo
 * @Description: leecode: 22. 括号生成
 */
package wyx.leetcode2024.wyx20240715;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtarck(n, n, "");
        return res;
    }

    private void backtarck(int left, int right, String str) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        if (left == right) {
            backtarck(left - 1, right, str + "(");
        } else if(left < right){
            if (left > 0) {
                backtarck(left - 1, right, str + "(");
            }
            backtarck(left, right - 1, str + ")");
        }
    }
}

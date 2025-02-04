/*
 * @Author: Tungbo
 * @Date: 2022-12-23 23:14:43
 * @LastEditTime: 2022-12-23 23:21:51
 * @LastEditors: Tungbo
 * @Description: leecode: 2011. 执行操作后的变量值
 * 
 * 存在一种仅支持 4 种操作和 1 个变量 X 的编程语言：
 *  ++X 和 X++ 使变量 X 的值 加 1
 *  --X 和 X-- 使变量 X 的值 减 1
 * 最初，X 的值是 0
 * 给你一个字符串数组 operations ，这是由操作组成的一个列表，返回执行所有操作后， X 的 最终值 。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221219;

public class Solution2011 {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];
            if(op.contains("++")) ans++;
            else ans--;
        }
        return ans;
    }
}

/*
 * @Author: Tungbo
 * @Date: 2022-08-31 14:51:52
 * @LastEditTime: 2022-08-31 15:09:08
 * @LastEditors: Tungbo
 * @Description: leecode: 946. 验证栈序列
 * 
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false
 * 
 */
package wyx.wyx20220829;

import java.util.LinkedList;

public class Solution946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int pushIdx = 0;
        for (int i = 0; i < popped.length; i++) {
            while(stack.isEmpty() || (pushIdx < pushed.length && popped[i] != stack.peek())) {
                stack.push(pushed[pushIdx++]);
            }
            if(popped[i] == stack.peek()) stack.pop(); 
        }
        return stack.isEmpty();
    }

}

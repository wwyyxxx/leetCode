/*
 * @Author: Tungbo
 * @Date: 2023-04-10 17:27:17
 * @LastEditTime: 2023-04-10 18:24:41
 * @LastEditors: Tungbo
 * @Description: leecode: 1019. 链表中的下一个更大节点
 */
package wyx.wyx20230410;

import java.util.ArrayDeque;
import java.util.Deque;

import wyx.bean.ListNode;

public class Solution0119 {
    
    int[] ans;
    Deque<Integer> stack = new ArrayDeque<Integer>();
    public int[] nextLargerNodes(ListNode head) {
        dfs(head, 0);
        return ans;
    }

    private void dfs(ListNode head, int i) {
        if(head == null) {
            ans = new int[i];
            return;
        }
        dfs(head.next, i+1);
        while(!stack.isEmpty() && stack.peek() <= head.val) {
            stack.pop();
        }
        if(!stack.isEmpty()) ans[i] = stack.peek();
        stack.push(head.val);
    }
}

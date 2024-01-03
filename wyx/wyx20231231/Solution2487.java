/*
 * @Author: Tungbo
 * @Date: 2024-01-03 21:23:56
 * @LastEditTime: 2024-01-03 21:55:07
 * @LastEditors: Tungbo
 * @Description: leecode: 2487. 从链表中移除节点
 */

import java.util.ArrayDeque;
import java.util.Deque;

import wyx.bean.ListNode;

public class Solution2487 {

    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<ListNode>();
        for(; head != null; head = head.next) {
            stack.push(head);
        }
        for(; !stack.isEmpty(); stack.pop()) {
            if(head == null || stack.peek().val >= head.val) {
                stack.peek().next = head;
                head = stack.peek();
            }
        }
        return head;
    }
}
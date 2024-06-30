/*
 * @Author: Tungbo
 * @Date: 2024-06-30 15:54:13
 * @LastEditTime: 2024-06-30 16:35:47
 * @LastEditors: Tungbo
 * @Description: leecode: 24. 两两交换链表中的节点
 */
package wyx.leetcode2024.wyx20240624;

import wyx.bean.ListNode;

public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode tail = new ListNode(0, head);
        ListNode temp = tail;
        
        while (temp.next != null && temp.next.next != null) {
            
            ListNode n1 = temp.next;
            ListNode n2 = temp.next.next;
            
            temp.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            temp = n1;
        }
        return tail.next;
    }
}

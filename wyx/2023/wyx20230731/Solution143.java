/*
 * @Author: Tungbo
 * @Date: 2023-07-31 11:41:08
 * @LastEditTime: 2023-08-03 15:07:40
 * @LastEditors: Tungbo
 * @Description: leecode: 143. 重排链表
 */
package wyx.wyx20230731;

import java.util.List;

import wyx.bean.ListNode;
import wyx.other.reverseTree;

public class Solution143 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next !=null && fast.next.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;

        newHead = reverseList(newHead);

        //链表节点依次连接
        while (newHead != null) {
            ListNode temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = temp;
        }
    }

    private ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode tail = head;
        head = head.next;
        tail.next = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }
        return tail;
    }
}

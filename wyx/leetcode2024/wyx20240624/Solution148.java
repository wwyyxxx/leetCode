/*
 * @Author: Tungbo
 * @Date: 2024-06-30 17:36:55
 * @LastEditTime: 2024-06-30 19:33:28
 * @LastEditors: Tungbo
 * @Description: leecode: 148. 排序链表
 */
package wyx.leetcode2024.wyx20240624;

import java.util.Comparator;
import java.util.PriorityQueue;

import wyx.bean.ListNode;

public class Solution148 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode fast = head.next, slow = head;
        while (fast != null && slow.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode dummy = new ListNode(0), currNode = dummy;
        
        while (left != null && right != null) {
            if(left.val < right.val) {
                currNode.next = left;
                left = left.next;
            } else {
                currNode.next = right;
                right = right.next;
            }
            currNode = currNode.next;
        }

        currNode.next = left == null ? right : left;
        return dummy.next;
    }
}

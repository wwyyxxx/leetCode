/*
 * @Author: Tungbo
 * @Date: 2024-06-30 16:38:13
 * @LastEditTime: 2024-06-30 17:33:21
 * @LastEditors: Tungbo
 * @Description: leecode: 25. K 个一组翻转链表
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240624;

import practice.leetcode.src.wyx.bean.ListNode;

public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prervNode = null, curNode = head;
        while (curNode != null) {
            ListNode next = curNode.next;
            curNode.next = prervNode;
            prervNode = curNode;
            curNode = next;
        }
        return prervNode;
    }
}

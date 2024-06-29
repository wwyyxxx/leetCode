/*
 * @Author: Tungbo
 * @Date: 2024-06-25 15:05:02
 * @LastEditTime: 2024-06-25 15:13:48
 * @LastEditors: Tungbo
 * @Description: leecode: 141. 环形链表
 */
package wyx.leetcode2024.wyx20240624;

import wyx.bean.ListNode;

public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head, fast = head.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }
        return false;
    }
}

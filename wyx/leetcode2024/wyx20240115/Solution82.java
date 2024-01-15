/*
 * @Author: Tungbo
 * @Date: 2024-01-15 15:07:14
 * @LastEditTime: 2024-01-15 15:33:40
 * @LastEditors: Tungbo
 * @Description: leecode: 82. 删除排序链表中的重复元素 II
 */
package wyx.leetcode2024.wyx20240115;

import wyx.bean.ListNode;

public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next !=null && cur.next.next != null) {
            if(cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

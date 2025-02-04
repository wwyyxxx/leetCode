/*
 * @Author: Tungbo
 * @Date: 2024-06-29 21:22:21
 * @LastEditTime: 2024-06-29 21:22:25
 * @LastEditors: Tungbo
 * @Description: leecode: 19. 删除链表的倒数第 N 个结点
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240624;

import practice.leetcode.src.wyx.bean.ListNode;

public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode frist = head, second = dummy;
        for(int i = 0; i < n; i++) {
            frist = frist.next;
        }
        
        while(frist != null) {
            frist = frist.next;
            second = second.next;
        }
        second.next = second.next == null ? null : second.next.next;
        return dummy.next;
    }
}

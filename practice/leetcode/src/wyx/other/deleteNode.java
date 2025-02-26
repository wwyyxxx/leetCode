package practice.leetcode.src.wyx.other;

import practice.leetcode.src.wyx.bean.ListNode;

/*
 * @Author: Tungbo
 * @Date: 2021-07-05 18:52:58
 * @LastEditTime: 2022-05-26 21:57:30
 * @LastEditors: Tungbo
 * @Description: leecode: 删除链表的节点
 */
class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode cur = head;
        if(head.val == val) return head.next;
        while(head.next != null) {
            if(head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return cur;
    }
}
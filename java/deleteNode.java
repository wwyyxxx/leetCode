import bean.ListNode;

/*
 * @Author: Tungbo
 * @Date: 2021-07-05 18:52:58
 * @LastEditTime: 2021-07-05 18:53:16
 * @LastEditors: Tungbo
 * @Description: leecode: 删除链表的节点
 */
class Solution {
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
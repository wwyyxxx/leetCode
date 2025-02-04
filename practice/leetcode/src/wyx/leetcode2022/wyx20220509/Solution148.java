package practice.leetcode.src.wyx.leetcode2022.wyx20220509;

import practice.leetcode.src.wyx.bean.ListNode;

/*
 * @Author: Tungbo
 * @Date: 2022-05-12 15:23:04
 * @LastEditTime: 2022-05-26 21:58:23
 * @LastEditors: Tungbo
 * @Description: leecode: 排序链表
 */
public class Solution148 {

    // 归并排序..自底向上
    // 递归--终止条件 head==null || head.next == null
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fast = head, slow = head;
        while (fast!=null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;;
        ListNode h = new ListNode(0);
        ListNode left = sortList(slow);
        ListNode right = sortList(temp);
        
        while (left!=null && right!=null) {
            if(left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left==null ? right : left;
        return h.next;
    }

}
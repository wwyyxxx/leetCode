/*
 * @Author: Tungbo
 * @Date: 2024-06-26 16:48:42
 * @LastEditTime: 2024-06-26 17:01:49
 * @LastEditors: Tungbo
 * @Description: leecode: 21. 合并两个有序链表
 */
package wyx.leetcode2024.wyx20240624;

import wyx.bean.ListNode;

public class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0) , cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1; 
        return dummy.next;
    }
}

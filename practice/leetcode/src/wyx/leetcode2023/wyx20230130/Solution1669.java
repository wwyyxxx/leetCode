/*
 * @Author: Tungbo
 * @Date: 2023-01-30 12:41:10
 * @LastEditTime: 2023-01-30 13:27:47
 * @LastEditors: Tungbo
 * @Description: leecode: 1669. 合并两个链表
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230130;

import practice.leetcode.src.wyx.bean.ListNode;

public class Solution1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(0,list1);
        ListNode pre = null, cur = null;
        while(list1.next!=null) {
            if(a == 1) pre = list1;
            if(b == 0) cur = list1.next;
            list1 = list1.next;
            a--;b--;
        }
        pre.next = list2;
        while(list2.next != null) list2 = list2.next;
        list2.next = cur;
        return dummy.next;
    }
}

/*
 * @Author: Tungbo
 * @Date: 2022-09-06 11:39:37
 * @LastEditTime: 2022-09-06 14:53:49
 * @LastEditors: Tungbo
 * @Description: leecode: 2. 两数相加
 * 
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字
 * 你将两个数相加，并以相同形式返回一个表示和的链表
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
 * 
 */
package wyx.wyx20220905;

import wyx.bean.ListNode;

public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int flag = 0;
        while(l1 != null || l2 != null) {
            int v1 = l1 != null? l1.val : 0;
            int v2 = l2 != null? l2.val : 0;
            int temp = v1 + v2 + flag;
            flag = temp / 10;
            temp %= 10;
            cur.next = new ListNode(temp);
            cur = cur.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(flag != 0) cur.next = new ListNode(flag);
        return dummy.next;
    }

}

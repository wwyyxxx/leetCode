/*
 * @Author: Tungbo
 * @Date: 2024-06-29 20:48:48
 * @LastEditTime: 2024-06-29 21:10:13
 * @LastEditors: Tungbo
 * @Description: leecode: 2. 两数相加
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240624;

import practice.leetcode.src.wyx.bean.ListNode;

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;

            int temp = carry + v1 + v2;
            carry = temp / 10;
            ListNode newNode = new ListNode(temp %  10);
            cur.next = newNode;
            cur = cur.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        if(carry != 0) cur.next = new ListNode(carry);
        return dummy.next;
    }  
}

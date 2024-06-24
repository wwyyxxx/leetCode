/*
 * @Author: Tungbo
 * @Date: 2024-06-24 17:31:39
 * @LastEditTime: 2024-06-24 17:36:06
 * @LastEditors: Tungbo
 * @Description: leecode: 160. 相交链表
 */
package wyx.leetcode2024.wyx20240624;

import wyx.bean.ListNode;

public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Set<ListNode> dic = new HashSet<>();
        // while(headA != null) {
        //     dic.add(headA);
        //     headA = headA.next;
        // }
        // while(headB != null) {
        //     if(dic.contains(headB)) return headB;
        //     dic.add(headB);
        //     headB = headB.next;
        // }
        // return null;
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (headA != null && headA != null) {
            if(pA == pB) return pA;
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
            
        }
        return pA;
    }
}

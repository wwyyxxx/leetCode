/*
 * @Author: Tungbo
 * @Date: 2024-07-03 21:08:04
 * @LastEditTime: 2024-07-03 21:22:11
 * @LastEditors: Tungbo
 * @Description: leecode: 23. 合并 K 个升序链表
 */
package wyx.leetcode2024.wyx20240701;

import wyx.bean.ListNode;

public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++){
            ans = mergeLists(ans, lists[i]);
        }
        return ans;
        
    }

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode result = new ListNode(0);
        ListNode tail = result, aPtr = l1, bPtr = l2;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return result.next;
    }
}

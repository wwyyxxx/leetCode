/*
 * @Author: Tungbo
 * @Date: 2024-06-24 19:01:16
 * @LastEditTime: 2024-06-24 19:39:43
 * @LastEditors: Tungbo
 * @Description: leecode: 206. 反转链表
 */
package wyx.leetcode2024.wyx20240624;

import wyx.bean.ListNode;

public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode curNode = head, prevNode = null;
        while (curNode != null) {
            ListNode temp = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = temp;
        }
        return prevNode;
    }
}

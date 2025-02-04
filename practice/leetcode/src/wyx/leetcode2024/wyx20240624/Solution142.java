/*
 * @Author: Tungbo
 * @Date: 2024-06-25 15:14:49
 * @LastEditTime: 2024-06-26 14:52:19
 * @LastEditors: Tungbo
 * @Description: leecode: 142. 环形链表 II
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240624;

import practice.leetcode.src.wyx.bean.ListNode;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slowNode = head, fastNode = head;
        while (true) {
            if (fastNode == null || fastNode.next == null) {
                return null;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if(slowNode == fastNode) break;
        }
        fastNode = head;
        while (fastNode != slowNode) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }
}

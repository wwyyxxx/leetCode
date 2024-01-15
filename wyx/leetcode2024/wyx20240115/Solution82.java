/*
 * @Author: Tungbo
 * @Date: 2024-01-15 15:07:14
 * @LastEditTime: 2024-01-15 15:14:59
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
package wyx.leetcode2024.wyx20240115;

import wyx.bean.ListNode;

public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        int curNum = 101;
        ListNode prev, next, curr = head;
        ListNode dummy = new ListNode(0, head);
        while (head != null) {
            
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }

        }
    }
}

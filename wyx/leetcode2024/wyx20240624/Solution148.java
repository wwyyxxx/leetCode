/*
 * @Author: Tungbo
 * @Date: 2024-06-30 17:36:55
 * @LastEditTime: 2024-06-30 19:13:37
 * @LastEditors: Tungbo
 * @Description: leecode: 148. 排序链表
 */
package wyx.leetcode2024.wyx20240624;

import java.util.Comparator;
import java.util.PriorityQueue;

import wyx.bean.ListNode;

public class Solution148 {
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {

            @Override
            public int compare(Integer l1, Integer l2) {
                return l1 - l2;
            }
            
        });

        while(head != null) {
            queue.add(head.val);
            head = head.next;
        }

        ListNode result = new ListNode(-1), cur = result;
        while (!queue.isEmpty()) {
            cur.next = new ListNode(queue.poll());
            cur = result.next;
        }
        return result.next;
    }
}

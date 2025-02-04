/*
 * @Author: Tungbo
 * @Date: 2022-06-18 19:58:18
 * @LastEditTime: 2022-06-18 20:08:41
 * @LastEditors: Tungbo
 * @Description: leecode: 剑指 Offer II 029. 排序的循环链表
 * 
 * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220613;

import practice.leetcode.src.wyx.bean.Node;

public class Solution029 {
    
    public Node insert(Node head, int insertVal) {
        Node dummy = head;
        Node t = new Node(insertVal);
        t.next = t;
        if(head == null) return t;
        Node curr = head, next = head.next;
        while(next != head) {
            //比前一个节点大， 比后一个节点小
            if(insertVal >= curr.val && insertVal <= next.val) break;
            
            //循环了一圈 ，curr结尾，next开头
            if(curr.val > next.val) {
                //比结尾大，比开头小
                if(insertVal > curr.val || insertVal < next.val) break;
            }
            curr = curr.next;
            next = next.next;
        }
        curr.next = t;
        t.next = next;
        return dummy;
    }

}

package java;
import java.bean.ListNode;

/*
 * @Author: Tungbo
 * @Date: 2021-07-05 11:19:21
 * @LastEditTime: 2021-07-05 11:19:52
 * @LastEditors: Tungbo
 * @Description: leecode: 合并两个排序的链表
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while(l1!=null && l2 != null) {
            if(l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 != null ? l1 : l2;
        return result.next;
    }
}
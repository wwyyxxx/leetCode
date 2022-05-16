package java;

import java.bean.ListNode;
import java.util.Stack;

/*
 * @Author: Tungbo
 * @Date: 2021-06-16 15:56:52
 * @LastEditTime: 2021-07-26 15:19:47
 * @LastEditors: Tungbo
 * @Description: leecode: 从尾到头打印链表
 */
public class ReversePrint {
    public static void main(String[] args) {
        
    }
    
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] ids = new int[stack.size()];
        int j = 0;
        while (!stack.isEmpty()) {
            ids[j++] = (stack.pop());
        }
        return ids;
    }

}
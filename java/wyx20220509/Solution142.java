/*
 * @Author: Tungbo
 * @Date: 2022-05-12 15:23:04
 * @LastEditTime: 2022-05-12 15:52:07
 * @LastEditors: Tungbo
 * @Description: leecode: 环形链表 II
 */
public class Solution142 {

    public static void main(String[] args) {
    }

    public ListNode detectCycle(ListNode head) {
        // fast->走两步  slow->走一步
        // fast==slow有环。 fastlength = 2*slowLength
        // a=公共路径  b = 环长度
        // fastlength = 2*slowLength    fastlength = slowLength + n*b
        // s = n*b    f = 2*n*b
        // k = a + n*b
        ListNode fast = head, slow = head;
        while (fast!=null && fast != slow) {
            if(fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode res = head;
        while(res != slow) {
            res = res.next;
            slow = slow.next;
        }
        return res;
    }
}

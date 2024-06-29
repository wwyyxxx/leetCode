/*
 * @Author: Tungbo
 * @Date: 2024-06-24 19:33:16
 * @LastEditTime: 2024-06-24 19:55:11
 * @LastEditors: Tungbo
 * @Description: leecode: 234. 回文链表
 */
package wyx.leetcode2024.wyx20240624;

import java.util.ArrayList;
import java.util.List;

import wyx.bean.ListNode;

public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int l = 0, r = list.size() -1;
        while (l < r) {
            if (list.get(l++) != list.get(r--)) {
                return false;
            }
        }
        return true;
    }
}

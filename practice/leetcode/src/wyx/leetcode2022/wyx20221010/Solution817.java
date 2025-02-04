/*
 * @Author: Tungbo
 * @Date: 2022-10-12 15:49:13
 * @LastEditTime: 2022-10-12 15:56:54
 * @LastEditors: Tungbo
 * @Description: leecode: 817. 链表组件
 * 
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表 nums，该列表是上述链表中整型值的一个子集
 * 返回列表 nums 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 nums 中）构成的集合
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221010;

import java.util.HashSet;
import java.util.Set;

import practice.leetcode.src.wyx.bean.ListNode;

public class Solution817 {

    public int numComponents(ListNode head, int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (Integer num : nums)
            set.add(num);
        while (head != null) {
            if (set.contains(head.val)) {
                while (head != null && set.contains(head.val))
                    head = head.next;
                answer++;
            } else {
                head = head.next;
            }
        }
        return answer;
    }

}

/*
 * @Author: Tungbo
 * @Date: 2024-07-03 20:37:20
 * @LastEditTime: 2024-07-03 21:06:59
 * @LastEditors: Tungbo
 * @Description: leecode: 138. 随机链表的复制
 */
package wyx.leetcode2024.wyx20240701;

import java.util.HashMap;
import java.util.Map;

import wyx.bean.RandomNode;

public class Solution138 {

    Map<RandomNode, RandomNode> map = new HashMap<RandomNode, RandomNode>();
    public RandomNode copyRandomList(RandomNode head) {
        if (head == null) {
            return null;
        }
        RandomNode cur = head;

        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while(cur != null) {
            map.put(cur, new RandomNode(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }
}

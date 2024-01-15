/*
 * @Author: Tungbo
 * @Date: 2022-07-26 15:35:28
 * @LastEditTime: 2022-07-26 16:24:46
 * @LastEditors: Tungbo
 * @Description: leecode: 1206. 设计跳表
 * 
 * 不使用任何库函数，设计一个 跳表 
 * 跳表 是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似
 * 例如，一个跳表包含 [30, 40, 50, 60, 70, 90] ，然后增加 80、45 到跳表中，以下图的方式操作：
 * 
 * 跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(n))，空间复杂度是 O(n)
 * 注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。
 */
package wyx.wyx20220725;

import java.util.Arrays;
import java.util.Random;

public class Skiplist {
    int level = 10;
    class Node {
        int val;
        Node[] ne = new Node[level];
        Node (int _val) {
            val = _val;
        }
    }
    Random random = new Random();
    Node he = new Node(-1);
    void find(int t, Node[] ns) {
        Node cur = he;
        for (int i = level - 1; i >= 0; i--) {
            while (cur.ne[i] != null && cur.ne[i].val < t) cur = cur.ne[i];
            ns[i] = cur;
        }
    }
    public boolean search(int t) {
        Node[] ns = new Node[level];
        find(t, ns);
        return ns[0].ne[0] != null && ns[0].ne[0].val == t;
    }
    public void add(int t) {
        Node[] ns = new Node[level];
        find(t, ns);
        Node node = new Node(t);
        for (int i = 0; i < level; i++) {
            node.ne[i] = ns[i].ne[i];
            ns[i].ne[i] = node;
            if (random.nextInt(2) == 0) break;
        }
    }
    public boolean erase(int t) {
        Node[] ns = new Node[level];
        find(t, ns);
        Node node = ns[0].ne[0];
        if (node == null || node.val != t) return false;
        for (int i = 0; i < level && ns[i].ne[i] == node; i++) ns[i].ne[i] = ns[i].ne[i].ne[i];
        return true;
    }
}

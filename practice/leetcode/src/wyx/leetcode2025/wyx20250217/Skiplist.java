/*
 * @Author: Tungbo
 * @Date: 2025-02-23 14:41:30
 * @LastEditTime: 2025-02-23 15:13:12
 * @LastEditors: Tungbo
 * @Description: leecode: 1206. 设计跳表
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250217;

import java.util.Random;

public class Skiplist {

    int level = 10;
    class Node {
        int val;
        Node[] ne = new Node[level];
        Node(int _val) {
            val = _val;
        }
    }

    Random rand = new Random();
    Node he = new Node(-1);

    void find(int t, Node[] ns) {
        Node cur = he;
        for(int i = level - 1; i >= 0; i--) { 
            while(cur.ne[i] != null && cur.ne[i].val < t) cur = cur.ne[i];
            ns[i] = cur;
        }
    }

    public Skiplist() {
        
    }
    
    public boolean search(int target) {
        Node[] ns = new Node[level];
        find(target, ns);
        return ns[0].ne[0] != null && ns[0].ne[0].val == target;
    }
    
    public void add(int num) {
        Node[] ns = new Node[level];
        find(num, ns);
        Node node = new Node(num);
        for(int i = 0; i < level; i++) {
            node.ne[i] = ns[i].ne[i];
            ns[i].ne[i] = node;
            if(rand.nextInt(2) == 0) break;
        }
    }
    
    public boolean erase(int num) {
        Node[] ns = new Node[level];
        find(num, ns);
        Node node = ns[0].ne[0];
        if (node == null || node.val != num) return false;
        for (int i = 0; i < level && ns[i].ne[i] == node; i++) ns[i].ne[i] = ns[i].ne[i].ne[i];
        return true;
    }
}

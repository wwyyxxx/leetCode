/*
 * @Author: Tungbo
 * @Date: 2023-11-03 15:12:34
 * @LastEditTime: 2023-11-03 16:41:29
 * @LastEditors: Tungbo
 * @Description: leecode: 117. 填充每个节点的下一个右侧节点指针 II
 */
package wyx.wyx20231030;

import java.util.LinkedList;
import java.util.Queue;

import wyx.bean.Node;

public class Solution117 {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node cur = queue.poll();
                cur.next = (i == n -1) ? null : queue.peek();
                if(cur.left!=null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return root;
    }
}

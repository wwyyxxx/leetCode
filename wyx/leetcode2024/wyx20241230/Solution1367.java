package wyx.leetcode2024.wyx20241230;

import wyx.bean.ListNode;
import wyx.bean.TreeNode;

/*
 * @Author: Tungbo
 * @Date: 2024-12-30 23:34:46
 * @LastEditTime: 2024-12-30 23:36:33
 * @LastEditors: Tungbo
 * @Description: leecode: 1367. 二叉树中的链表
 */
public class Solution1367 {
    
    private ListNode head;
    
    public boolean isSubPath(ListNode head, TreeNode root) {
        this.head = head;
        return dfs(head,root);
    }
        
    private boolean dfs(ListNode h, TreeNode root) {
        if (h == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        return h.val == root.val && (dfs(h.next, root.left) || dfs(h.next, root.right)) || 
            h == head && (dfs(head, root.left) || dfs(h, root.right));
    }
}

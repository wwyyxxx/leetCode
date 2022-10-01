/*
 * @Author: Tungbo
 * @Date: 2022-08-30 10:55:54
 * @LastEditTime: 2022-08-30 14:32:54
 * @LastEditors: Tungbo
 * @Description: leecode: 998. 最大二叉树 II
 * 
 * 最大树 定义：一棵树，并满足：其中每个节点的值都大于其子树中的任何其他值。
 * 
 * 给你最大树的根节点 root 和一个整数 val 
 * 请注意，题目没有直接给出 a ，只是给出一个根节点 root = Construct(a) 。
 * 假设 b 是 a 的副本，并在末尾附加值 val。题目数据保证 b 中的值互不相同。
 * 返回 Construct(b)
 * 
 */
package wyx.wyx20220829;
import wyx.bean.TreeNode;

public class Solution998 {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        TreeNode prev = null, cur = root;
        while(cur != null && cur.val > val) {
            prev = cur;
            cur = cur.right;
        }
        if(prev == null) {
            node.left = cur;
            return node;
        } else {
            node.left = cur;
            prev.right = node;
            return root;
        }
        
    }
    
}
